function Ajax(async, url, data, done) {
    $.ajax({
    	url : url,
        type : "post",
        async : async,
        data : data,
        success : function(data){
        	eval("done('" + data +"')");
        }
    })
}

function jump(url) {
	window.location.href = url;
}