package com.example.demo.utils;

public class ResponseBodyDTO {

    public record ResBodyOneDTO(long id, String content, int num) {}

    public record ResBodyTwoDTO(int id, String content, int num, int value) {}

    public record ResBodyThreeDTO(int id, String content, int num, String val) {}

    public static class Success {

        String status = "success";
        String message = "No message...";

        public Success() {}

        public Success(String message) {
            this.message = message;
        }

        public Success(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
