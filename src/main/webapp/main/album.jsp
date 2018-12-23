<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var id;
    $("#updateAlbum").dialog({
        width: 400,
        height: 200,
        title: '专辑详情',
        href: "${pageContext.request.contextPath }/main/updateAlbum.jsp",
        closed: true
    });
    $("#addAlbum").dialog({
        width: 400,
        height: 300,
        title: '添加专辑',
        href: "${pageContext.request.contextPath }/main/addAlbum.jsp",
        closed: true
    });
    //初始化添加音频的对话框dialog
    $("#addChapter").dialog({
        width: 400,
        height: 300,
        title: '添加专辑',
        href: "${pageContext.request.contextPath }/main/addChapter.jsp",
        closed: true
    });
    var toolbar = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row != null) {
                id = row.id;
                $("#updateAlbum").dialog("open");
            } else {
                alert("请先选中修改行")
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            //点击弹出表格
            $("#addAlbum").dialog("open");
        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
           $("#addChapter").dialog("open")
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            $("#dg").edatagrid("saveRow")

        }
    }]
    $(function () {
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/albumpage',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'duration', title: '时长', width: 80},
                {field: 'size', title: '大小', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            pagination: true,
            pageSize: 2,
            pageList: [2, 5, 7]
        });
    })

</script>

<table id="album"></table>
<div id="updateAlbum"></div>
<div id="addAlbum"></div>
<div id="addChapter"></div>