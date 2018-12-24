<%@page pageEncoding="utf-8" %>

<title>Insert title here</title>
<script type="text/javascript">
    $(function () {
       // alert(id);
        console.log(rr);
        $("#updateForm").form("load",rr);
        $("#album_img").prop("src", "${pageContext.request.contextPath}/img/" + rr.coverImg)
        //Id
        $("#updateFormID").validatebox({
            readonly: true

        });
        //表单验证
        $("#updateFormtitle").textbox({
            required: true

        });

        $("#updateFormcount").textbox({
            required: true

        });

        $("#updateFormcoverImg").textbox({
            required: true

        });
        $("#updateFormscore").textbox({
            required: true

        });

        //提交按钮
        $("#updateAlnbumSubmit").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#updateForm").form("submit", {
                    url: "${pageContext.request.contextPath }/updateAlbum",
                    onSubmit: function () {
                        return $("#updateForm").form("validate");
                    },
                    success: function () {
                        $("#updateDialog").dialog("close");
                        $("#table").datagrid("reload");

                        $.messager.show({
                            title: "提示信息",
                            msg: "修改成功"

                        });
                    }

                });

            }
        });

    });

</script>


<form id="updateForm" method="post">
    ID:<input id="updateFormID" name="id"><br/>
    title<input id="updateFormtitle" name="title"/><br/>
    count<input id="updateFormcount" name="count"/><br/>
    coverImg
    <div>
        <img src="" id="album_img">
    </div>
    score<input id="updateFormscore" name="score"/><br/>
    auther<input id="updateFormauther" name="auther"/><br/>
    broadcast<input id="updateFormbroadcast" name="broadcast"/><br/>
    brief<input id="updateFormbrief" name="brief"/><br/>
    pubDate<input id="updateFormpubDate" name="pubDate"/><br/>

    <a id="updateAlnbumSubmit">修改</a>
</form>
