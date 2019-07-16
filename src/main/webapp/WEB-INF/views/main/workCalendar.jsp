<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/jstl_taglib.jsp" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/common/popup_header.jsp"%>

<link href='/common/calendar/core/main.css' rel='stylesheet' />
<link href='/common/calendar/daygrid/main.css' rel='stylesheet' />

<script src='/common/calendar/core/main.js'></script>
<script src='/common/calendar/daygrid/main.js'></script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');
	    var lang_cd = 'ko';
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	    	plugins: [ 'interaction','dayGrid' ],
	    	
	        defaultDate: '2019-05-16',
	        //locale: initialLocaleCode,
	        editable: true,
	        navLinks: true,
	        eventLimit: true,
	        events: function(start, end, timezone, callback) {
	            $.ajax({
	                url: '/workCalendarList',
	                type : 'post',
	                //data : {EVENT_CODE : '11', LANG : lang_cd, startDate : start.format(), endDate : end.format() },
	                dataType: 'json',
	                success: function(data) {
	                	alert(data);
	                  /*   var events = [];
	                    $(data).each(function() {
	                        events.push({
	                            title: $(this).attr('title'),
	                            start: $(this).attr('start'),
	                            end: $(this).attr('end'),
	                            //url: "/test/eventDetail.do?id="+$(this).attr('id')+"&amp;lang="+$(this).attr('lang')+"&amp;start="+$(this).attr('start')+"&amp;end="+$(this).attr('end'),
	                            lang : $(this).attr('lang')
	                        });
	                    }); */
	                    callback(events);
	                }
	            });
	 
	        }
	    	       
	    	       
	    });
	
	    calendar.render();
	  });

</script>
 


<div id='calendar'></div>

</body>

</html>
