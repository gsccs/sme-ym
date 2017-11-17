$('#sitem_list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+'/appeal/item/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			//rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'topictitle',
				title : '事项名称',
				width : 100
			},{
				field : 'content',
				title : '事项内容',
				width : 250
			}, {
				field : 'corptitle',
				title : '企业',
				width : 150
			}, {
				field : 'addtimestr',
				title : '提交日期',
				width : 150
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "草稿";
			    	}else if(value=='2') {
			    		str = "已提交";
			    	}else if(value=='3') {
			    		str = "已接收";
			    	}else if(value=='4') {
			    		str = "已办理";
			    	}
			    	return str;
				}
			},{
				field : 'result',
				title : '处理结果',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "接受";
			    	}else{
			    		str = "驳回";
			    	}
			    	return str;
				}
			}]],
			toolbar : [ {
				text : '查看',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '办理',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '关闭',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			},  '-', {
				text : '查看申报情况',
				iconCls : 'icon-more',
				handler : function() {
					list();
				}
			} ]
		});