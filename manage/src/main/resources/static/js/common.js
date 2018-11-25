/**
 * 常规的ajax-rest请求处理
 */
var ajaxRestRequest = function (options) {

    //请求开始处理
    ajaxRestStart(option);
    var newUrl = option.url;
    var isRest =option.isRest;

    $.ajax({
        url : getFuncIdUrl(newUrl,currentToken),
        type : option.type,
        data : option.data,
        dataType: "json",
        async:option.async!=undefined?option.async:true,
        cache:false,
        beforeSend:function(xhr) {
            xhr.setRequestHeader("Accept", "application/json;charset=UTF-8");
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            if(option.beforeSend){
                option.beforeSend(xhr);
            };
        },
        dataFilter : function() {
            if(option.dataFilter){
                option.dataFilter(response, dataType);
            }
        },
        success:function(data, textStatus, jqXHR){
            //结束ajax请求
            ajaxRestEnd(option);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            //结束ajax请求
            ajaxRestEnd(option);
        },
        complete : function(xmlRequest, statusCode) {
            systemDate = xmlRequest.getResponseHeader( "Date" );
            //进行超时处理
            if(statusCode=="timeout"){
                statusCodeHandel(option,true)["timeout"]();
            }

            if(option.complete){
                option.complete(xmlRequest, statusCode);
            }
        },
        statusCode : statusCodeHandel(option,isRest)
    });

};
/**
 * ajax 请求开始处理
 */
function ajaxRestStart(option){
    //如果存在按钮
    if(option.btn){
        $(option.btn).attr("disabled", "disabled");
    }
    App.startPageLoading({animate:true});
}
/**
 * ajax 请求结束处理
 */
function ajaxRestEnd(option){
    App.stopPageLoading();
    if(option.btn){
        $(option.btn).removeAttr("disabled");
    }
}