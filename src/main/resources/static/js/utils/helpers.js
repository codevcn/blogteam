const queryStringGetter = (param) => {
    return new URLSearchParams(window.location.search).get(param);
};

const toastify = {
    error: ({ title, msg, html }) => {
        Swal.fire({
            title,
            ...(html ? { html } : { text: msg }),
            icon: "error",
        });
    },
    success: ({ title, msg, html }) => {
        Swal.fire({
            title,
            ...(html ? { html } : { text: msg }),
            icon: "success",
        });
    },
    confirm: ({ title, msg }, callback) => {
        Swal.fire({
            title,
            text: msg,
            icon: "warning",
            showCancelButton: true,
        }).then((result) => {
            if (result.isConfirmed) {
                callback();
            }
        });
    },
};
