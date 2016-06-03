$('a.icon').hover(function () {
    $(this).children($('img')).animate({borderSpacing: +90}, {
        step: function (now, fx) {
            $(this).css('-webkit-transform', 'rotate(' + now + 'deg)');
            $(this).css('-moz-transform', 'rotate(' + now + 'deg)');
            $(this).css('transform', 'rotate(' + now + 'deg)');
        },
        duration: 'slow'
    }, 'linear');
}, function () {
    $(this).children($('img')).animate({borderSpacing: 0}, {
        step: function (now, fx) {
            $(this).css('-webkit-transform', 'rotate(' + now + 'deg)');
            $(this).css('-moz-transform', 'rotate(' + now + 'deg)');
            $(this).css('transform', 'rotate(' + now + 'deg)');
        },
        duration: 'slow'
    }, 'linear');
})

$('ul.sort-list>li>a').click(function () {
    var string="";
    switch(this.getAttribute('id')) {
        case "sort-by-date":
            string="date-sorting";
            break;
        case "sort-by-place":
            string="place-sorting";
            break;
        case "sort-by-search":
            string="filter-sorting";
            break;
        default:
            break;
    }
    $('.'+string).addClass("show");
    $('body').append("<div class=\"back\"></div>");
    $('.back').click(function () {
        $('.back').remove();
        $(".show").removeClass("show");
    })

    $('.close-modale').click(function () {
        $('.back').remove();
        $(".show").removeClass("show");
    })
})