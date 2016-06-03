
    $('a.icon').hover(function() {
        $(this).children($('img')).animate({  borderSpacing: +90 }, {
            step: function(now,fx) {
                $(this).css('-webkit-transform','rotate('+now+'deg)');
                $(this).css('-moz-transform','rotate('+now+'deg)');
                $(this).css('transform','rotate('+now+'deg)');
            },
            duration:'slow'
        },'linear');
    },function () {
        $(this).children($('img')).animate({  borderSpacing: 0 }, {
            step: function(now,fx) {
                $(this).css('-webkit-transform','rotate('+now+'deg)');
                $(this).css('-moz-transform','rotate('+now+'deg)');
                $(this).css('transform','rotate('+now+'deg)');
            },
            duration:'slow'
        },'linear');
    })