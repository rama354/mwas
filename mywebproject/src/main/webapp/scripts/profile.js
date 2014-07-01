function includejsp(anchor){
  var tabnum=anchor.getAttribute("href").substr(1);
  //document.getElementById(tabnum).style.visibility="visible";
  
  document.getElementById("tab_content").innerHTML=document.getElementById(tabnum).innerHTML;
}

function editAboutMe()
{
	document.getElementById("aboutme_text").removeAttribute("readonly");
	return false;
}