function a(id){
	 return document.querySelector(id);
}

var op;
var needReset=false;
var prevV=0;
var needClear=false;
var curV;
var result;
var dupOp=false;
//hello
function appendDigit(dit){

   if(needClear===true){
    return;
   }

   var val=a("#cal-show").value;
   console.log(needReset);
   if(val==="0"||needReset===true){
   	  val=dit;
   	  needReset=false;
   }
   else{
   	console.log(val);
   	val += dit;

   }
   console.log(val);
   console.log(dit);
   console.log(result);
   // debugger;  
   dupOp=false;
   a("#cal-show").value=val; //here don't forget #sign 
}

function plus(){

     if(needClear===true){
      return;
     }
    if(dupOp===false){
    equalValue();
    }
    var i=1;
  	op="+";
    prevV=Number(a("#cal-show").value);
    needReset=true;
    dupOp=true;
}

function multiply(){
     if(needClear===true){
      return;
     }
       
    if(dupOp===false){
    equalValue();
    }
  	 op="*";
    prevV=Number(a("#cal-show").value);
    needReset=true;
    dupOp=true; 
 }
function minus(){
    if(needClear===true){
    return;
    }
    if(dupOp===false){
    equalValue();
    }
    op="-";
    prevV=Number(a("#cal-show").value);
    needReset=true; 
    dupOp=true;
}
function division(){
    if(needClear===true){
     return;
    }
   if(dupOp===false){
    equalValue();
    }
    op="/";
    prevV=Number(a("#cal-show").value);
    needReset=true; 
    dupOp=true;
}
function BitchyClear(){

   // console.log("~~Hello world ~~");
   op=null;
   needReset=true;
   prevV=null;
   curV=null;
   result=null;
   needClear=false;
   a("#cal-show").value="0";
   
}
function bs(){
   if(needClear===true){
    return;
   }
   console.log(a("#cal-show").value);
   var val = a("#cal-show").value;
   var len=val.length;
   //debugger;
   val=val.substring(0,len-1);
   if(val.length === 0){
    val = "0";
   }
   a("#cal-show").value=val;
}



function equalValue(){
   if(needClear===true){
    return;
   }

    curV=Number(a("#cal-show").value);
    result = curV;
    if(op==="+"){
    	result=curV+prevV;
    }
    

    if(op==="-"){
      console.log("prevV: " + prevV);
      console.log("curV: " + curV);
    	result=prevV-curV;
    }

    if(op==="*"){
    	result=curV*prevV;
    }

    if(op==="/"){
    	
      	result=prevV/curV;
    	// console.log(result);
    	if(result===Infinity){
    		a("#cal-show").value="Divided by 0!";
        needClear=true;
    		return;
    	}
      if(curV===0&&prevV===0){
        //console.log("hhehehhaheh");
        a("#cal-show").value="0/0 Not allowed!";
        needClear=true;
        return;
      }
    }
    if(result>100000000000){
      a("#cal-show").value="out of bounds!"
      needClear=true;
      return;
    }
    

    a("#cal-show").value=result;
    needReset=true;
    op="";  //setting continuous =  to unavailable .
    
}

