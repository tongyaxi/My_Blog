function category_click(btn){
 	var value = btn.value;
 	var category = document.getElementById("category");
 	category.value=value;

 }
 function tags_click(btn){	
	var value = btn.value;
	var tags = document.getElementById("tags");
	var tags_value = tags.value;
	//既存のタグに含まれるか判断する
	if(tags_value.indexOf(value) > -1)return ;
	tags.value = tags_value+" "+value;
 }
