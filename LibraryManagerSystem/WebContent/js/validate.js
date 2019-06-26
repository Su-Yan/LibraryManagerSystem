var icpw=0;
var icp=0;
var icem=0;
var icid=0;
var icac=0;
var icamt=0;

function disableSubmitButton(){
	var btnsubmit=document.getElementById("btnSubmit");
	btnsubmit.disabled=true;
	
}

function enableSubmitButton(){
	var btnsubmit=document.getElementById("btnSubmit");
	var cnt=icpw+icp+icem+icid+icac;
	if(cnt==0){
		btnsubmit.disabled=false;
	}
	
}

function confirmPassword(){
	var pw=document.getElementsByName("Password");
	var cpw=document.getElementsByName("ConfirmPassword");
	var tip="";
	if(pw[0].value!=cpw[0].value){
		tip="The two password is not same! Please check!"
		disableSubmitButton();
		icpw++;
	}else{
		icpw=0;
		enableSubmitButton();
	}
	var tiplabel=document.getElementsByName("cpwlb");
	tiplabel[0].innerHTML=tip;
}

function checkPhone(){
    var p = document.getElementsByName("PhoneNumber");
    var phone=p[0].value;
	var pnlb=document.getElementsByName("pnlb");
    if(!(/^1[3456789]\d{9}$/.test(phone))){ 
    	pnlb[0].innerHTML="Phone number is wrong!";
    	disableSubmitButton();
    	icp++;
    } else{
    	icp=0;
    	pnlb[0].innerHTML="";
    	enableSubmitButton();
    }
	
}

function checkIdentifyID(){
    var p = document.getElementsByName("IdentifyID");
    var id=p[0].value;
    var idlb= document.getElementsByName("idlb");
    if(!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(id))){
    	idlb[0].innerHTML="Your identity is wrong!";
    	disableSubmitButton();
    	icid++;
    }else{
    	icid=0;
    	idlb[0].innerHTML="";
    	enableSubmitButton();
    }
	
}

function checkEmail(){
	var p=document.getElementsByName("Email");
	var email=p[0].value;
	var emlb=document.getElementsByName("emlb");
	if(!(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(email))){
		emlb[0].innerHTML="Your email is wrong!";
		disableSubmitButton();
		icem++;
	}else{
		icem=0;
		emlb[0].innerHTML="";
		enableSubmitButton();
	}
}

function checkBookAmount(){
	var p=document.getElementsByName("Amount");
	var Amount=p[0].value;
	var emlb=document.getElementsByName("amtlb");
	if(!(/^\d+/.test(Amount))){
		emlb[0].innerHTML="Your amount is wrong!";
		disableSubmitButton();
		icamt++;
	}else{
		icem=0;
		emlb[0].innerHTML="";
		enableSubmitButton();
	}
	
}
