package com.example.demo.DTOs.blog;

import com.example.demo.utils.constants.Lengths;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateBlogDTO {

    @NotBlank(message = "Trường tiêu đề không thể thiếu")
    @Size(
        min = Lengths.minLengthOfTitleBlog,
        max = Lengths.maxLengthOfTitleBlog,
        message = "Trường tiêu đề không thể vượt ngoài giới hạn kí tự (" +
        Lengths.minLengthOfMainContentBlog +
        "-" +
        Lengths.maxLengthOfMainContentBlog +
        ")"
    )
    private String title;

    @NotBlank(message = "Trường nội dung chính blog không thể thiếu")
    @Size(
        min = Lengths.minLengthOfMainContentBlog,
        max = Lengths.maxLengthOfMainContentBlog,
        message = "Trường nội dung chính blog không thể vượt ngoài giới hạn kí tự (" +
        Lengths.minLengthOfMainContentBlog +
        "-" +
        Lengths.maxLengthOfMainContentBlog +
        ")"
    )
    private String mainContent;

    @NotBlank(message = "Trường id phân loại không thể thiếu")
    private String hashtag;
}
