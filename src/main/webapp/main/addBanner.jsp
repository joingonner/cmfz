<%@ page pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function() {

        // 初始化 表单控件-帐号
        $("#updateUserFormTitle").textbox({
            required : true
        });
        // 初始化 表单控件-密码
/*        $("#updateUserFormImgPuth").textbox({
            required : true,
            type : "file"
        });*/
        //
        $("#updateUserFormPubDate").textbox({
            required : true,
            validType : 'date'
        });
        // 初始化 表单控件-添加
        $("#updateUserFormStatus").textbox({
            required : true
        });
        $("#updateUserFormDescription").textbox({
            required : true
        });

        $("#addUserFromSave1").linkbutton({
            onClick : function() {
                // 提交表单 -- 调form的submit方法
                $("#updateUserForm").form("submit", {
                    url : "${pageContext.request.contextPath }/upload",
                    onSubmit : function() {
                        // 表单验证 -- 调form的validate方法
                        return $("#addUserForm").form("validate");
                    },
                    success : function() {
                        $.messager.show({
                            title : "标题",
                            msg : "保存成功！"
                        });
                        $("#addBanner").dialog("close");
                        $("#dg").edatagrid("load");
                    }
                });
            }
        });
        // 初始化 表单控件-重置
        $("#addUserdialogAdd").linkbutton();

    });
</script>

<form id="updateUserForm" method="post" enctype="multipart/form-data">
    title：<input id="updateUserFormTitle" name="title" /><br />
    img：<input id="updateUserFormImgPuth" type="file" name="img" /><br />
    pubDate：<input id="updateUserFormPubDate" class="easyui-datebox" name="pubDate" /><br />
    status：
    <input  type="radio" name="status" value="Y">显示
    <input  type="radio" name="status" value="N">不显示<br />
    description：<input id="updateUserFormDescription" name="description" /><br />

</form>
<a  id="addUserFromSave1">提交</a>

