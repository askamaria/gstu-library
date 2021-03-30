(function initializeEvents() {
    paginationEvents();
    sortingEvents();
    authorSearchEvent();
    genreSortingEvent();
})();

function paginationEvents() {
    const pageLinks = document.getElementsByClassName("page-link");
    Array.from(pageLinks).forEach((element => element.onclick = function (event) {
        const pageLink = event.target;
        const pageNumber = pageLink.innerHTML;
        const paginationUrl = new URL("/home", document.location);
        paginationUrl.searchParams.append("page", pageNumber);
        addSortedByToUrl(paginationUrl);
        addGenreToUrl(paginationUrl);
        addAuthorToUrl(paginationUrl);
        window.location.href = decodeURI(paginationUrl.toString());
    }));
}

function sortingEvents() {
    const sortedLinks = document.getElementsByClassName("sorting-link");
    Array.from(sortedLinks).forEach((element => element.onclick = function (event) {
        const pageLink = event.target;
        const sortingUrl = new URL("/home", document.location);
        sortingUrl.searchParams.append("sortedBy", pageLink.getAttribute("value"));
        addAuthorToUrl(sortingUrl);
        addGenreToUrl(sortingUrl);
        window.location.href = decodeURI(sortingUrl.toString());
    }));
}

function authorSearchEvent() {
    const authorSearchButton = document.getElementById("author-search-button");
    authorSearchButton.onclick = function () {
        const authorInput = document.getElementById("author-search-input");
        const authorSearchUrl = new URL("/home", document.location);
        authorSearchUrl.searchParams.append("author", authorInput.value);
        addGenreToUrl(authorSearchUrl);
        addSortedByToUrl(authorSearchUrl);
        window.location.href = decodeURI(authorSearchUrl.toString());
    };
}

function genreSortingEvent() {
    const genreLinks = document.getElementsByClassName("genre-links");
    Array.from(genreLinks).forEach((element => element.onclick = function (event) {
        const genreLink = event.target;
        const genreSearchingUrl = new URL("/home", document.location);
        genreSearchingUrl.searchParams.append("genre", genreLink.innerText);
        addSortedByToUrl(genreSearchingUrl);
        addAuthorToUrl(genreSearchingUrl);
        window.location.href = decodeURI(genreSearchingUrl.toString());
    }));
}

function addGenreToUrl(url) {
    const activeGenre = document.getElementById("active-genre");
    if (activeGenre) {
        url.searchParams.append("genre", activeGenre.innerText);
    }
}

function addSortedByToUrl(url) {
    const sortedBy = document.getElementById("active-sorted-by");
    if (sortedBy) {
        url.searchParams.append("sortedBy", sortedBy.getAttribute("value"));
    }
}

function addAuthorToUrl(url) {
    const authorInput = document.getElementById("author-search-input");
    if (authorInput.value) {
        url.searchParams.append("author", authorInput.value);
    }
}