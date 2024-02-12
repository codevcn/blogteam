package com.example.demo.configs;

import com.example.demo.configs.props.AppInfoProps;
import com.example.demo.utils.client.ClientGlobalVarNames;
import com.example.demo.utils.client.ClientPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionCatcher {

    @Autowired
    private AppInfoProps appInfoService;

    private final int maxLengthOfErrorMessage = 100;

    private String specifyErrorMessage(String error_message) {
        return error_message.length() > maxLengthOfErrorMessage
            ? error_message.substring(0, maxLengthOfErrorMessage) + "..."
            : error_message;
    }

    private void logException(String exception_title, Exception exception) {
        System.out.printf("\n>>> run this " + exception_title + " catcher");
        System.out.printf("\n>>> :::::::::::::::::::::( \n");
        System.out.print(exception);
        System.out.printf("\n>>> :::::::::::::::::::::) \n");
    }

    private void logValidationException(MethodArgumentNotValidException exception) {
        System.out.printf("\n>>> run this Method Argument Not Valid Exception catcher\n");
        exception
            .getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                System.out.printf(">>> error message: %s \n", error.getDefaultMessage());
            });
    }

    @ExceptionHandler({ Exception.class })
    public String handleAnyException(Exception exception, Model model) {
        logException("Any Exception", exception);

        model.addAttribute(ClientGlobalVarNames.appName, appInfoService.getAppName());
        model.addAttribute(ClientGlobalVarNames.error, specifyErrorMessage(exception.getMessage()));

        return ClientPages.page500;
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public String handleMethodArgumentNotValidException(
        MethodArgumentNotValidException exception,
        Model model
    ) {
        logValidationException(exception);

        String errorMessage =
            "Dữ liệu đầu vào không hợp lệ: " +
            exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        model.addAttribute(ClientGlobalVarNames.appName, appInfoService.getAppName());
        model.addAttribute(ClientGlobalVarNames.error, specifyErrorMessage(errorMessage));

        return ClientPages.page500;
    }

    @ExceptionHandler({ DataAccessException.class })
    public String handleDataAccessException(DataAccessException exception, Model model) {
        logException("Data Access Exception", exception);

        model.addAttribute(ClientGlobalVarNames.appName, appInfoService.getAppName());
        model.addAttribute(ClientGlobalVarNames.error, specifyErrorMessage(exception.getMessage()));

        return ClientPages.page500;
    }

    @ExceptionHandler({ RuntimeException.class })
    public String handleRuntimeException(RuntimeException exception, Model model) {
        logException("Runtime Exception", exception);

        model.addAttribute(ClientGlobalVarNames.error, specifyErrorMessage(exception.getMessage()));
        model.addAttribute(ClientGlobalVarNames.appName, appInfoService.getAppName());

        return ClientPages.page500;
    }

    @ExceptionHandler({ NoResourceFoundException.class })
    public String handleNoResourceFoundException(NoResourceFoundException exception, Model model) {
        logException("No Resource Found Exception", exception);

        model.addAttribute(ClientGlobalVarNames.appName, appInfoService.getAppName());
        model.addAttribute(ClientGlobalVarNames.error, specifyErrorMessage(exception.getMessage()));

        return ClientPages.page404;
    }
}
