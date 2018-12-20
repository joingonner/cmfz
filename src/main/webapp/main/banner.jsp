<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        var toolbar=[{
            iconCls: 'icon-add',
            text:"添加",
            handler: function () {
                alert('编辑按钮')
            }
        }, '-', {
            iconCls: 'icon-edit',
            text:"修改",
            handler: function () {
                var row= $("#dg").edatagrid("getSelected");
                if(row!=null){
                    var index = $("#dg").edatagrid("getRowIndex",row);
                    $("#dg").edatagrid("editRow",index);
                }else{
                    alert("请先选中修改行")
                }
            }
        },  '-',{
            text:"删除",
            iconCls: 'icon-no',
            handler: function () {
                alert('帮助按钮')
            }
        },  '-',{
            text:"保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]
        $('#dg').edatagrid({
            updateUrl:"${pageContext.request.contextPath}/update",
            url: '${pageContext.request.contextPath}/page',
            columns: [[
                {field: 'title', title: '名字', width: 100},
                {field: 'status', title: '状态', width: 100,editor:{
                    type:"text",
                        options:{
                        required:true
                        }
                    }},
                {field: 'pubDate', title: '时间', width: 100, align: 'right'}
            ]],
            fitColumns: true,
            pagination: true,
            pageSize: 3,
            pageList: [3, 5, 7],
            toolbar:toolbar,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    })

</script>
<table id="dg"></table>
