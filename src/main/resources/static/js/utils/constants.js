// regex
const email_pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
const password_pattern = /^(?=.*[a-zA-Z])(?=.*\d).{4,}$/;
const fullName_pattern = /^.{3,30}$/;

// lengths
const min_content_letters_count = 100;
const max_content_letters_count = 4000;
const min_title_letters_count = 2;
const max_title_letters_count = 100;
