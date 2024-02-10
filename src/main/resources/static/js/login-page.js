const form = document.querySelector(".form");
const emailInput = form.querySelector("input[name='email']");
const passwordInput = form.querySelector("input[name='password']");

const check_required_inputs = ({ email, password }) => {
    if (email.trim() === "" || password.trim() === "") {
        toastify.error({
            title: "Đăng ký thất bại",
            html: "Vui lòng không bỏ trống bất kì trường nào!",
        });
        return false;
    }
    return true;
};

const validate_form = () => {
    const email = emailInput.value;
    const password = passwordInput.value;

    return check_required_inputs({ email, password });
};
