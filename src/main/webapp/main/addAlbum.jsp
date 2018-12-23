<%@ page pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function() {

        // 初始化 表单控件-帐号
        $("#addFormtitle").textbox({
            required : true
        });
        // 初始化 表单控件-密码
/*        $("#updateUserFormImgPuth").textbox({
            required : true,
            type : "file"
        });*/
        //
        $("#addFormcount").textbox({
            required : true,
            validType : 'date'
        });
        // 初始化 表单控件-添加
        $("#addFormcount").textbox({
            required : true
        });
        $("#addFormscore").textbox({
            required : true
        });
        $("#addFormauther").textbox({
            required : true
        });
        $("#addFormbroadcast").textbox({
            required : true
        });
        $("#addFormbrief").textbox({
            required : true
        });
        $("#addFormpubDate").datebox({
            required : true
        });
        $("#addAlnbumSubmit").linkbutton({
            onClick : function() {
                // 提交表单 -- 调form的submit方法
                $("#addForm").form("submit", {
                    url : "${pageContext.request.contextPath }/addAlbum",
                    onSubmit : function() {
                        // 表单验证 -- 调form的validate方法
                        return $("#addUserForm").form("validate");
                    },
                    success : function() {
                        $.messager.show({
                            title : "标题",
                            msg : "保存成功！"
                        });
                        $("#addAlbum").dialog("close");
                        $("#album").treegrid("load");
                    }
                });
            }
        });
        // 初始化 表单控件-重置
        $("#addUserdialogAdd").linkbutton();

    });
</script>

<form id="addForm" method="post" enctype="multipart/form-data">
    title<input id="addFormtitle" name="title" /><br/>
    count<input id="addFormcount" name="count" /><br/>
    coverImg<input id="addFormcoverImg"  type="file" name="img"/><br/>
    score<input id="addFormscore" name="score"/><br/>
    auther<input id="addFormauther" name="auther"/><br/>
    broadcast<input id="addFormbroadcast" name="broadcast"/><br/>
    brief<input id="addFormbrief" name="brief"/><br/>
    pubDate<input id="addFormpubDate" name="pubDate"/><br/>

    <a id="addAlnbumSubmit">添加</a>
</form>


