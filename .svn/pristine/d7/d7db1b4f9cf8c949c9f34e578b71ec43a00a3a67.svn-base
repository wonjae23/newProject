<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="personal_layer">
			<div class="bg"></div>
			<div class="pop-layer" id="layer2">
				<div class="pop-container">
					<div class="pop-conts">
						<!--content //-->
						<p class="ctxt mb20"><b><font color="red" size=3>개인정보 노출 주의!</font></b><br><br>
						<font color="black">현재 접속한 메뉴에는 회원의 개인정보가 노출되어 있습니다.<br>
							해당 페이지내에서는 <font color="red">마우스 우클릭, 드래그, 복사</font>의 기능이<Br> 
							<font color="red">제한</font>되오니	이용에 참고하여 주시기 바랍니다.</font>
						</p>

						<div class="btn-r">
							<a class="cbtn" href="#">Close</a>
						</div>
						<!--// content-->
					</div>
				</div>
			</div>
		</div>
		<style type="text/css">
			.personal_layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100;}
			.personal_layer .bg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=80);}
			.personal_layer .pop-layer {display:block;}

			.pop-layer {display:none; position: absolute; top: 50%; left: 50%; width: 410px; height:auto;  background-color:#fff; border: 5px solid #3571B5; z-index: 10;}	
			.pop-layer .pop-container {padding: 20px 25px;}
			.pop-layer p.ctxt {color: #666; line-height: 25px;}
			.pop-layer .btn-r {width: 100%; margin:10px 0 20px; padding-top: 10px; border-top: 1px solid #DDD; text-align:right;}

			a.cbtn {display:inline-block; height:25px; padding:0 14px 0; border:1px solid #304a8a; background-color:#3f5a9d; font-size:13px; color:#fff; line-height:25px;}	
			a.cbtn:hover {border: 1px solid #091940; background-color:#1f326a; color:#fff;}
		</style>
		<script type="text/javascript">
			function layer_open(el){
				var temp = $('#' + el);
				var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

				
				if(bg){
					$('.personal_layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
				}else{
					temp.fadeIn();
				}

				// 화면의 중앙에 레이어를 띄운다.
				if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
				else temp.css('top', '0px');
				if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
				else temp.css('left', '0px');

				temp.find('a.cbtn').click(function(e){
					if(bg){
						$('.personal_layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
					}else{
						temp.fadeOut();
					}
					e.preventDefault();
				});

				$('.personal_layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
					$('.personal_layer').fadeOut();
					e.preventDefault();
				});

			}
			
			if('${req.player}'=='Y')
			layer_open('layer2');
			</script>	
<script src="/common/js/commonUI.js"></script>
</body>
</html>