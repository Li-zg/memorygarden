/*提交回复*/
function post() {
    var questionId = $("#question-id").val();//获取问题id
    var content = $("#comment-content").val();//获取问题内容
    comment2target(questionId, 1, content);//提交问题
}

function comment2target(targetId, type, content) {
    if (!content) {
        alert("请输入内容~_~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=4adb67f3c6fb88caff6c&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

/*回复二级评论*/
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2target(commentId, 2, content);
}

/*展开二级评论*/
function collapseComments(e) {
    var id = e.getAttribute("data-id");//获取点击评论的id
    var comments = $("#comment-" + id);//获取点击评论的子回复部分的div
    //二级评论展开
    $.getJSON( "/comment/"+id, function( data ) {
        console.log(data);
        comments.toggleClass("in");
    });

}