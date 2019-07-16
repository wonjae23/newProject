function SpeedPlayTime(player) {
	
	var self_ = this;
	var time_ = 0;
	var ticks_;
	var timer = null;
	var current_position_ = 0;
	var start_ = 0;
	
	//2013-05-24 
	var duration_;
	
	var complete = false;
	player.bindEvent("play_state_change", __onPlayStateChange);
	function __onPlayStateChange(state) {
		switch (state) {
		case PlayState.PLAYING:
			go();
			break;
		case PlayState.PAUSED:
			stop();
			break;
		case PlayState.STOPPED:	
			complete = false;
			stop();
			break;
		case PlayState.BUFFERING_STARTED:
			stop();
			break;
		case PlayState.COMPLETE:
			complete = true;
			setTimeout(function(){
				account(new Date().getTime(), duration_);
			}, 100);
			break;
		}
	}
	
	this.getTime = function () {
		return parseInt(time_, 10);
	}
	
	function go() {
		ticks_ = new Date().getTime();
		if (timer == null) {
			timer = setInterval(function(){
				account(new Date().getTime(), parseInt(player.getCurrentPosition(), 10));
			}, 1000);
		}
	}
	
	function stop() {
		clearInterval(timer);
		timer = null;
	}

	function account(ticks, current) {
		if (current > 0)
			current_position_ = parseInt(current, 10);
		var rate = new Number(player.getRate());
		var temp = ticks - ticks_;
		time_ +=  temp * rate.toFixed(1) / 1000;
		ticks_ = ticks;
		
$('#debug2').text('time : ' + parseInt(time_) + " sec / " + rate.toFixed(1)); 		

	}


}

