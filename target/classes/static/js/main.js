document.addEventListener('DOMContentLoaded', function () {
    const heroLink = document.querySelector('a[href="#cars"]');
    if (heroLink) {
        heroLink.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector('#cars');
            if (target) {
                target.scrollIntoView({ behavior: 'smooth' });
            }
        });
    }
});
