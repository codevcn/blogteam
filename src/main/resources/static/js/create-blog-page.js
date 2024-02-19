const font_families_for_quilljs = ["Arial", "Roboto", "Times-New-Roman", "Poppins", "Work-Sans"];
const font_sizes_for_quilljs = ["11px", "14px", "18px", "24px", "30px"];

// init elements that usable right away
const letters_counter_ele = document.getElementById("editor-counter");
const main_content_ele = document.getElementById("quill-editor");
const blog_title_ele = document.querySelector(".editor-container .add-title");

const quill_editor_options = {
    theme: "snow",
    placeholder: "Viết nội dung của bạn...",
    modules: {
        toolbar: "#quill-toolbar",
        history: {
            delay: 1000,
            maxStack: 50,
            userOnly: false,
        },
    },
};

// custom font families quill
const FontAttributor = Quill.import("attributors/class/font");
FontAttributor.whitelist = font_families_for_quilljs;
Quill.register(FontAttributor, true);

// custom font sizes quill
const SizeAttributor = Quill.import("attributors/style/size");
SizeAttributor.whitelist = font_sizes_for_quilljs;
Quill.register(SizeAttributor, true);

// generate quill editor
const quill = new Quill("#quill-editor", quill_editor_options);

// letters counter
const count_letters_in_editor = () => quill.getText().length;

quill.on(Quill.events.TEXT_CHANGE, function letters_counter() {
    letters_counter_ele.innerText = count_letters_in_editor() - 1;
});

// add tooltip to toolbar formats
const add_tooltip_to_buttons = (tooltip_element, hidden_class) => {
    const format_buttons = document.querySelectorAll(
        ".editor-container .ql-toolbar.ql-snow .ql-formats button"
    );
    if (format_buttons.length === 0) return;

    for (const button of format_buttons) {
        tooltip_element.innerHTML = button.getAttribute("data-tooltip");
        button.appendChild(tooltip_element.cloneNode(true));

        button.addEventListener("mouseover", function () {
            button.querySelector(".quill-toolbar-tooltip").classList.remove(hidden_class);
        });

        button.addEventListener("mouseout", function () {
            button.querySelector(".quill-toolbar-tooltip").classList.add(hidden_class);
        });
    }
};

const add_tooltip_to_pickers = (tooltip_element, hidden_class) => {
    const format_picker_labels = document.querySelectorAll(
        ".editor-container .ql-toolbar.ql-snow .ql-formats .ql-picker-label"
    );
    if (format_picker_labels.length === 0) return;

    for (const picker of format_picker_labels) {
        tooltip_element.innerHTML = picker.parentElement.getAttribute("data-tooltip");
        picker.appendChild(tooltip_element.cloneNode(true));

        picker.addEventListener("mouseover", function () {
            picker.querySelector(".quill-toolbar-tooltip").classList.remove(hidden_class);
        });

        picker.addEventListener("mouseout", function () {
            picker.querySelector(".quill-toolbar-tooltip").classList.add(hidden_class);
        });
    }
};

const add_tooltip_to_toolbar_formats = () => {
    const hidden_class = "hidden";

    const tooltip_element = document.createElement("div");
    tooltip_element.className = "quill-toolbar-tooltip " + hidden_class;

    add_tooltip_to_buttons(tooltip_element, hidden_class);
    add_tooltip_to_pickers(tooltip_element, hidden_class);

    tooltip_element.remove();
};
add_tooltip_to_toolbar_formats();

// validations
const validate_content_letters_count = () => {
    const content_length = count_letters_in_editor();
    if (content_length < min_content_letters_count || content_length > max_content_letters_count) {
        throw new Error(
            "Nội dung bài đăng phải có số lượng kí tự trong khoảng từ " +
                min_content_letters_count +
                " đến " +
                max_content_letters_count +
                " kí tự!"
        );
    }
};

const validate_title_letters_count = () => {
    const title_length = blog_title_ele.value.length;
    if (title_length < min_title_letters_count || title_length > max_title_letters_count) {
        throw new Error(
            "Tiêu đề phải có số lượng kí tự trong khoảng từ " +
                min_title_letters_count +
                " đến " +
                max_title_letters_count +
                " kí tự!"
        );
    }
};

const validate_blog = () => {
    validate_title_letters_count();
    validate_content_letters_count();
};

// request create blog
const create_blog = (blog) => {
    fetch(create_blog_api, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(blog),
        credentials: "include",
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(">>> Server response >>>", data);
        })
        .catch((error) => {
            console.error(">>> Create blog error >>>", error);
        });
};

// publish blog hanlder
const submit_publish_blog = async () => {
    try {
        validate_blog();
    } catch (error) {
        if (error !== null) {
            toastify.error({ title: "Xuất bản bài đăng thất bại", msg: error.message });
            return;
        }
    }

    const main_content = main_content_ele.querySelector(".ql-editor");
    const blog_title = blog_title_ele.value;

    create_blog({
        title: blog_title,
        mainContent: main_content.innerHTML,
        categoryID: "ooo-vcn",
    });
};
