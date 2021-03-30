(function initializeEvents() {
    onInputAuthorEnterEvent();
})();

function onInputAuthorEnterEvent() {
    document.addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            document.getElementById("author-search-button").click();
        }
    });
}