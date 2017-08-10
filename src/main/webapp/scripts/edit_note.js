/*
 * edit_note.js
 * 封装全部与笔记有关的脚本
 */
function showNotesAction(){
	//this 是li元素
	console.log(this);
	//获取选中元素的序号，此序号是在显示笔记本列表时绑定的。
	var li = $(this);
	var index = li.data('index');
	console.log(index);
	//处理视觉效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	//让模型显示当前笔记本的全部笔记
	model.showNotes(index);
}
/*
 	<a  class='checked'>
		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> 使用Java操作符<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>
	</a>
	<div class="note_menu" tabindex='-1'>
		<dl>
			<dt><button type="button" class="btn btn-default btn-xs btn_move" title='移动至...'><i class="fa fa-random"></i></button></dt>
			<dt><button type="button" class="btn btn-default btn-xs btn_share" title='分享'><i class="fa fa-sitemap"></i></button></dt>
			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title='删除'><i class="fa fa-times"></i></button></dt>
		</dl>
	</div>
 */
model.showNotes = function(notebookIndex){
	console.log(notebookIndex);
	//找到当前笔记本信息
	var notebook = this.notebooks[notebookIndex];
	console.log(notebook);
	//向服务器发起Ajax请求获取笔记本列表
	var url = "note/list.do";
	var data = {notebookId:notebook.id};
	console.log(data);
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			console.log(result.data);
			model.updateNotes(result.data);
			/*var list = result.data;
			this.notes = list;
			var ul = $('#notes').empty();
			for(var i=0;i<this.notes.length;i++){
				var note = this.notes[i];
				var li = template.replace('[notes.title]',note.title);
				li = $(li).data('index',i);
				ul.append(li);
			}*/
		}
	});
}
model.updateNotes = function(notes){
	
	var template='<li class="online">'+
		'<a>'+
			'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note.title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
		'</a>'+
		'<div class="note_menu" tabindex="-1">'+
			'<dl>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
			'</dl>'+
		'</div>'+
		'</li>';
	
	console.log(notes);
	this.notes = notes;
	var ul=$('#notes').empty();
	for(var i=0; i<this.notes.length; i++){
		var note=this.notes[i];
		var li = template.replace(
			'[note.title]', note.title);
		li = $(li);
		ul.append(li);
	}
};

//将 notes 显示到界面
model.updateNotes = function(notes){
	
	var template='<li class="online">'+
		'<a>'+
			'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note.title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'+
		'</a>'+
		'<div class="note_menu" tabindex="-1">'+
			'<dl>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
				'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
			'</dl>'+
		'</div>'+
		'</li>';
	
	console.log(notes);
	if(notes){
		this.notes = notes;
	}
	var ul=$('#notes').empty();
	for(var i=0; i<this.notes.length; i++){
		var note=this.notes[i];
		var li = template.replace(
			'[note.title]', note.title);
		li = $(li).data('index',i);
		if(i==this.noteIndex){
			li.children('a').addClass('checked');
		}
		ul.append(li);
	}
};

//edit_note.js
//处理笔记列表点击事件
function loadNoteAction(){
	//console.log('loadNoteAction');
	var li = $(this);//当前对象是li
	//处理显示效果
	li.parent().find('a').removeClass('checked');
	li.find('a').addClass('checked');
	//获取选的元素的序号
	var index = li.data('index');
	//console.log(index);
	
	model.loadNote(index);
}

//加载选定的笔记
model.loadNote = function(index){
	//在model中记录当前选定笔记的位置
	//在更新title时候，利用这个序号找到笔记位置
	this.noteIndex = index;
	//console.log(index);
	var url = 'note/load.do';
	var data={id:model.notes[index].id};
	console.log(url);
	console.log(data);
	$.getJSON(url, data, function(result){
		if(result.state==SUCCESS){
			//console.log(result.data);
			model.updateNote(result.data);
		}else{
			alert(result.message);
		}
	});
};
//将note对象显示到编辑区域
model.updateNote = function(note){
	this.note=note;
	$('#input_note_title').val(this.note.title);
	um.setContent(this.note.body);
};

//处理按钮时间
function saveNoteAction(){
	var title = $('#input_note_title').val();
	var body = um.getContent();
	var id = model.note.id;
	
	//不允许空title
	if(title.replace(" ","")==""){
		title = model.note.title;
		$('#input_note_title').val(title);
	}
	if(title==model.note.title && body==model.note.body){
		return ;
	}
	
	var url = "note/save.do";
	var data = {id:id,title:title,body:body};
	console.log(1);
	console.log(data);
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			if(result.data==false){
				alert("更新失败");
				return;
			}
			console.log("成功");
			//更新标题
			model.updateTitle(title);
		}else{
			alert(result.message);
		}
	});
}

model.updateTitle = function(title){
	console.log(title);
	//找到当前选定笔记的序号index
	var index = this.noteIndex;
	console.log(index);
	this.notes[index].title = title;
	//更新笔记列表显示
	this.updateNotes();
}

//响应添加笔记按钮事件，打开添加笔记对话框
function showAddNoteDialog(){
	$('#can').load('alert/alert_note.jsp');
	$('.opacity_bg').show();
}



