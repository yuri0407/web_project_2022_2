$(function(){
    //header menu------------------------------------
    $('header nav >ul').mouseenter(function(){
        $('ul.lv2, .headerBg').stop().slideDown()
    })
    $('header nav >ul').mouseleave(function(){
        $('ul.lv2, .headerBg').stop().slideUp()
    })

    
})