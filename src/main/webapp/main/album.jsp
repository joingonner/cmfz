<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var id;
    var rr;
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
                rr=row;
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
            var row = $("#album").treegrid("getSelected");
            if (row != null) {
                //编辑指定行
                /* $("#addChapterDialog").dialog("open");*/
                if(row.id%1 ===0 ){
                    alert("请选择音频");
                }else {
                    location.href="${pageContext.request.contextPath}/addFile/download?musicName="+row.url;
                }
            } else {
                alert("请先选中行")
            }

        }
    },'-', {
        text: "导出",
        iconCls: 'icon-remove',
        handler: function () {
            location.href="${pageContext.request.contextPath}/export"
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
            onDblClickRow:playAudio,
            pagination: true,
            pageSize: 2,
            pageList: [2, 5, 7]
        });
        //双击播放音频
        function playAudio(row){
            if(row.url != null && row.url != ""){
                console.log(row.url);
                $("#player").prop("src","${pageContext.request.contextPath}/music/"+row.url);
            }else{
                $.messager.alert("警告","请双击要播放的章节!");
            }
        }
    })

</script>
<table id="album">
    <audio id="player" controls="controls" autoplay="autoplay">
        <source src=""/>
    </audio>
</table>
<table id="album"></table>
<div id="updateAlbum"></div>
<div id="addAlbum"></div>
<div id="addChapter"></div>