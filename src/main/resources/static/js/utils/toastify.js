const toastify = {
    error: ({ title, msg, html }) => {
        Swal.fire({
            title,
            ...(html ? { html } : { text: msg }),
            icon: "error",
        });
    },
    success: ({ title, msg }) => {
        Swal.fire({
            title,
            ...(html ? { text: msg } : { html }),
            icon: "success",
        });
    },
};
