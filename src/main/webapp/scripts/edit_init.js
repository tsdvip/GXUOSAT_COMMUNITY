//edit_init.js 初始化

var SUCCESS = 0;

var model = {};//当前页面中的数据模型

$(function(){
	console.log('init()');
	//页面加载以后，立即加载笔记本列表
	loadNotebooksAction();//edit_notebook.js
	
	//绑定点击笔记本列表的事件
	//showNotesAction函数定义在edit_note.js中
	$('#notebooks').on('click','li',showNotesAction);
	//绑定点击笔记列表的事件
	$('#notes').on('click','li',loadNoteAction);
	
	$('#save_note').click(saveNoteAction);
	
	//绑定添加笔记按钮事件
	$('#add_note').click(showAddNoteDialog);
	
	$('#can').on('click','.close,.cancle',closeDialog)
});

function closeDialog(){
	$('#can').empty();
	$('.opacity_bg').hide();
}















