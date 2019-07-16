//패밀리사이트 셀렉메뉴
//패밀리사이트 레이어 기능
function showLayer(id){
	if(document.getElementById(id).style.display=='none'){
		document.getElementById(id).style.display='block';
	}else{
		document.getElementById(id).style.display='none';
	}
}
//레프트 메뉴
$(function(){

	//$("dd").not($("#select").next()).css("display","none");
	$("[id^=left_sub]").not($("#select").next()).css("display","none");
	//$("#select").css("border-bottom","1px solid #e4e4e4");
	
	$("dl dt").click(function(){
		if($("+[id^=left_sub]",this).css("display")=="none" ||  $("+dd",this).length==0){
			$("[id^=left_sub]").slideUp("slow");
			$("+[id^=left_sub]",this).slideDown("slow");
			//$("dt").css("border-bottom","1px solid #e4e4e4");
			if($("+dd",this).length>0 ){
				//$(this).css("border-bottom","0px");
			}
		}else{
			$("+[id^=left_sub]",this).slideUp("slow");
			//$("dt").css("border-bottom","1px solid #e4e4e4");
		}
		
	});
});
// 멤버쉽탭
(jQuery)(function($){
	/* tabMenu */
	function tabMenu(){
		if($('.tabMenu').length == 0) return false;
		var btn = $('.tabMenu').find('.btnTab');
		$(btn).on('click',function(){
			var h = $(this).height();
			var parent = $(this).parents('.tabMenu');
			var index = $(parent).find('.btnTab').index(this);
			var allTabSection = $(parent).find('.tabSection');
			var selectedTabSection = $(allTabSection).eq(index);
			var tHeight = $(parent).find('.tabContentsWrap').eq(index).height();
			if (selectedTabSection.hasClass('show') == false){
				$(allTabSection).removeClass('show').addClass('hide');
				$(selectedTabSection).removeClass('hide').addClass('show');
				//$('.tabMenu .inWrap').css('height',h+tHeight+3);
			}
		});
	}tabMenu();

});
//게시물 별
jQuery.fn.rating = function(url, options) {
	
	if(url == null) return;
	
	var settings = {
        url       : url, // post changes to 
        maxvalue  : 5,   // max number of stars
        curvalue  : 0    // number of selected stars
    };
	
    if(options) {
       jQuery.extend(settings, options);
    };
   jQuery.extend(settings, {cancel: (settings.maxvalue > 1) ? true : false});
   
   
   var container = jQuery(this);
	
	jQuery.extend(container, {
            averageRating: settings.curvalue,
            url: settings.url
        });

	for(var i= 0; i <= settings.maxvalue ; i++){
		var size = i
        if (i == 0) {
			if(settings.cancel == true){
	             var div = '<div class="cancel"><a href="javascript:void(0);" onclick="rating(\'0\')" title="Cancel Rating">Cancel Rating</a></div>';
				 container.append(div);
			}
        } 
		else {
             var div = '<div class="star"><a href="javascript:void(0);" onclick="rating(\''+i+'\');" title="Give it '+i+'/'+size+'">'+i+'</a></div>';
			 container.append(div);

        }
 
		

	}
	
	var stars = jQuery(container).children('.star');
    var cancel = jQuery(container).children('.cancel');
	
    stars
	        .mouseover(function(){
                event.drain();
                event.fill(this);
            })
            .mouseout(function(){
                event.drain();
                event.reset();
            })
            .focus(function(){
                event.drain();
                event.fill(this)
            })
            .blur(function(){
                event.drain();
                event.reset();
            });

    stars.click(function(){
		if(settings.cancel == true){
            settings.curvalue = stars.index(this) + 1;
            jQuery.post(container.url, {
                "rating": jQuery(this).children('a')[0].href.split('#')[1] 
            });
			return false;
		}
		else if(settings.maxvalue == 1){
			settings.curvalue = (settings.curvalue == 0) ? 1 : 0;
			$(this).toggleClass('on');
			jQuery.post(container.url, {
                "rating": jQuery(this).children('a')[0].href.split('#')[1] 
            });
			return false;
		}
		return true;
			
    });

        // cancel button events
	if(cancel){
        cancel
            .mouseover(function(){
                event.drain();
                jQuery(this).addClass('on')
            })
            .mouseout(function(){
                event.reset();
                jQuery(this).removeClass('on')
            })
            .focus(function(){
                event.drain();
                jQuery(this).addClass('on')
            })
            .blur(function(){
                event.reset();
                jQuery(this).removeClass('on')
            });
        
        // click events.
        cancel.click(function(){
            event.drain();
			settings.curvalue = 0;
            jQuery.post(container.url, {
                "rating": jQuery(this).children('a')[0].href.split('#')[1] 
            });
            return false;
        });
	}
        
	var event = {
		fill: function(el){ // fill to the current mouse position.
			var index = stars.index(el) + 1;
			stars
				.children('a').css('width', '100%').end()
				.lt(index).addClass('hover').end();
		},
		drain: function() { // drain all the stars.
			stars
				.filter('.on').removeClass('on').end()
				.filter('.hover').removeClass('hover').end();
		},
		reset: function(){ // Reset the stars to the default index.
			stars.lt(settings.curvalue).addClass('on').end();
		}
	}        
	event.reset();
	
	return(this);	

}
//학습 컨텐츠 탑메뉴
$(document).ready(function(){
	
	//클릭시 펼치거 접기
	$("#close_menu").click(function(event){
		var submenu = $("#menu");
		
		if(submenu.is(":visible") ){
			submenu.slideUp();
		}else{
			submenu.slideDown();
		}

		submenu.click(function(){
			//alert($(this));
		});
	//마우스 오버시 메뉴 펼치기
	/*}).mouseover(function(){
		var submenu = $("#menu");
		submenu.slideDown();*/
	});

	// a태그에 클릭 이벤트를 발생시켜 메뉴가 펼쳤다 접기
	$("#close_menu").click();
});

//학습창왼쪽메뉴 펼치기
$(document).ready(function(){
  $("#navigation li a").on("click", function(e){
    e.preventDefault();
    var hrefval = $(this).attr("href");
    
    if(hrefval == "#about") {
      var distance = $('#mainpage').css('left');
      
      if(distance == "auto" || distance == "0px") {
        $(this).addClass("open");
        openSidepage();
      } else {
        closeSidepage();
      }
    }
  }); // end click event handler
  
  $("#navigation li a").on("hover", function(){
    var classval = $(this).hasClass("hovertrigger");
    
    if(classval == true) {
      var distance = $('#mainpage').css('left');
      
      if(distance == "auto" || distance == "0px") {
        $(this).addClass("open");
        openSidepage();
      }
    }
  }); // end hover event handler
  
  $("#closebtn").on("click", function(e){
    e.preventDefault();
    closeSidepage();
  }); // end close button event handler

  function openSidepage() {
    $('#mainpage').animate({
      left: '230px'
    }, 200, 'easeOutBack'); 
  }
  
  function closeSidepage(){
    $("#navigation li a").removeClass("open");
    $('#mainpage').animate({
      left: '0px'
    }, 200, 'easeOutQuint');  
  }
}); 
/*
//학습 컨텐츠 창 오른쪽 펼치기메뉴
$(document).ready(function(){
  $('#aboutright').css( {right: '350px'});

  $("#navigation li a").on("click", function(e){
    e.preventDefault();
    var hrefval = $(this).attr("href");
    
    if(hrefval == "#about") {
      var distance = $('#aboutright').css('right');
      
      if(distance == "auto" || distance == "350px") {
        $(this).addClass("open");
        openSidepage();
      } else {
        closeSidepage();
      }
    }
  }); // end click event handler
  
  $("#navigation li a").on("hover", function(){
    var classval = $(this).hasClass("hovertrigger");
    
    if(classval == true) {
      var distance = $('#aboutright').css('left');
      
      if(distance == "auto" || distance == "350px") {
        $(this).addClass("open");
        openSidepage();
      }
    }
  }); // end hover event handler
  
  $("#closebtn").on("click", function(e){
    e.preventDefault();
    closeSidepage();
  }); // end close button event handler

  function openSidepage() {
	window.resizeTo(1300,660);
	$('#aboutright').animate({
      right: '-10px', opacity: '1'
    }, 400, 'easeOutBack');
  }
  
  function closeSidepage(){
	window.resizeTo(1000,660);
    $("#navigation li a").removeClass("open");
    $('#aboutright').animate({
      right: '350px', opacity: '0'
    }, 400, 'easeOutQuint');  
  }
}); */