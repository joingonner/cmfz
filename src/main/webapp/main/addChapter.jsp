<%@page pageEncoding="utf-8" %>


<script type="text/javascript">


    $(function () {
        //表单验证
        $("#addTableCtitle").textbox({
            required: true,
            validType: "length[1,15]"
        });

        //表单验证
        $("#addTableCsize").textbox({
            required: true,
            validType: "length[1,11]"
        });

        //表单验证
        $("#addTableCduration").textbox({
            required: true,
            validType: "length[1,13]"
        });
        //提交按钮--事件
        $("#addAlbumSubmitBtn").linkbutton({
            iconCls: "icon-save",

            onClick: function () {
                $("#addAlbumTable").form("submit", {
                    url: "${pageContext.request.contextPath }/addFile/addChapter",
                    onSubmit: function () {
                        return $("#addAlbumTable").form("validate");

                    },
                    success: function () {
                        $("#addChapter").dialog("close");
                        $("#album").treegrid("reload");

                        $.messager.show({
                            title: "提示信息",
                            msg: "提交成功"

                        });
                    }


                });

            }
        });

        //初始化保存按钮
        $("#addAlbumSubmitBtn").linkbutton();

        //初始化时加载--category
        $("#addTableCaid").combobox({
            editable: false,
            width: 100,
            url: "${pageContext.request.contextPath }/getAllAlbum",
            valueField: "id",
            textField: "title",
            onLoadSuccess: function (data) {
                console.log(data);
                $("#addTableCaid").combobox("setValue", data[0].id);
            }


        });

    });
</script>
<title>Insert title here</title>

<form id="addAlbumTable" method="post" enctype="multipart/form-data">
    标题：<input id="addTableCtitle" name="title"/><br/>
    大小：<input id="addTableCsize" name="size"/><br/>
    时长：<input id="addTableCduration" name="duration"/><br/>
    文件：<input id="addTableCurl" type="file" name="path"/><br/>
    分组：<select id="addTableCaid" name="aid">
</select><br/>
    <!-- <input type="submit" value="添加"/><input type="reset" value="重置"/> -->
    <a id="addAlbumSubmitBtn">提交</a>
</form>
<a href='../view/list2.jsp'>返回</a>
