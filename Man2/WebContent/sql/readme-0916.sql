1.在页面引入 日期控件 
	1)到光盘项目源码中 复制 calendar.js文件
	2)在自己的项目下创建js文件夹 将calendar.js文件 粘贴到js文件夹下
	3)在html页面中 使用<script ></script> 将calendar.js文件 引入到页面中
	4)找到需要使用日期控件的 文本框 
		<input type="text" name="birthday" 
		id="birthday" value="" onfocus="calendar()" />
	添加 onfocus 事件 调用 calendar() 方法
	
	
2.在页面中引入 