
//Set the suffix 'Over' to the path of the image
function setImageOver(image){
	if (image){
		var path = image.src;
		if (path && path.length > 4){
			path = path.substring(0,path.length - 4)+"Over"+path.substring(path.length - 4,path.length);
			image.src = path;
		}
	}
}
//Delete the suffix 'Over' to the path of the image
function setImageOut(image){
	if (image){
		var path = image.src;
		if (path && path.length > 8){
			var subPath = path.substring(path.length - 8,path.length - 4);
			if (subPath == "Over"){
				path = path.substring(0,path.length - 8)+path.substring(path.length - 4,path.length);
				image.src = path;
			}
		}
	}
} 

function showHideId(idField) {	
	 
	if(idField.style.display=='none') {
		idField.style.display='';
	} else {
		idField.style.display='none';
	}
}

function showHideId(idField1, idField2) {
	if(idField1) {
		if(idField1.style.display=='none') {
			idField1.style.display='';
		} else {
			idField1.style.display='none';
		}		
	}

	if(idField2) {
		if(idField2.style.display=='none') {
			idField2.style.display='';
		} else {
			idField2.style.display='none';
		}
	} 
}

/**
 * This method ask for the confirmation before deleting a parameter (in PARAMETER table)
 
 * @param url url to call
 * @param parameterId the parameter ID
 * @param parameterContext the parameter context code
 * @param poolName the pool name
 * @param tableName the table name
 * @author David Degardin
 */
function confirmDeletion(url, parameterId, parameterContext, poolName, tableName) {
	if (confirm("Are you sure ?")) {
		AjaxCall(url, null, 'detail=false&parameterId=' + parameterId + '&parameterContext=' + parameterContext + '&pool=' + poolName + '&table=' + tableName);
	}
}

//executer du code si touche enter appuye (a utiliser avec onkeypress par exemple)
//exemple:onkeypress="return pressEnterKey(event,'myFunction();')"/>
function pressEnterKey(event,stringToEval){
	var iKeyCode=event.keyCode;
	if(iKeyCode==13){
		eval(stringToEval);
		return false;
	} else  {
		return true;
	}
}

function textLimit(field, maxlen, msg) {
	if (field.value.length > maxlen) {
		field.value = field.value.substring(0, maxlen);
		alert(msg);
	}
}


function back() {
	history.go(-1);
}

function editionPerson(context, param) {
	location.href=context + '/main/person/editionPerson.do?matricule=' + param;
}

function generateCv(context){
	location.href=context + '/main/template/populate.do';
}

function downloadCv(context){
	location.href=context + '/main/template/download.do';
}

function listePersons(context, param) {
	location.href=context + '/main/person/listePersons.do';
}
/********************************
 
//ajout lien Fiche Collaborateurs//
*/

function listeEmploies(context, param){
	location.href=context + '/main/collaborater/listeEmploies.do';
}

function editionCHFR(context, param){
	location.href=context + '/main/collaborater/editionCHFR.do';
}

function editionCollaborater(context, param){
	location.href=context + '/main/collaborater/editionCollaborater.do?matricule=' + param;
}

function listeItems(context, param) {
	location.href=context + '/main/item/listeItems.do';
}

function listeCategories(context, param) {
	location.href=context + '/main/category/listeCategories.do';
}

function listeBusinessUnits(context, param) {
	location.href=context + '/main/businessunit/listeBusinessUnits.do';
}

function listSkill(context, param) {
	location.href=context + '/main/skill/listeSkills.do?matricule=' + param;
}

function uploadPicture(context, param) {
	location.href=context + '/main/person/uploadPicture.do';
}

function setSkillLevel(context, lvl, param, id, itemId) {
	location.href=context + '/main/skill/updateSkills.do?matricule=' + param+'&lvl='+lvl+'&id='+id+'&itemId='+itemId;
}

function searchSkillManager(contextPath) {
	location.href=contextPath+"/main/search/search.do";
}

function showTrombinoscope(context, param) {
	location.href=context + '/main/person/showTrombinoscope.do';
}

/** skill part **/
function refreshSkillStars(id, lvl) {
	
	for(var i=lvl; i>0; i--) {
		image = document.getElementById(id + i);
		if (image){
			var path = image.src;
			if (path && path.length > 4){
				path = path.substring(0,path.length - 5)+"1"+path.substring(path.length - 4,path.length);
				image.src = path;
			}
		}
	}
	
	for(var i=lvl+1; i<=5; i++) {
		image = document.getElementById(id + i);
		if (image){
			var path = image.src;
			if (path && path.length > 4){
				path = path.substring(0,path.length - 5)+"0"+path.substring(path.length - 4,path.length);
				image.src = path;
			}
		}
	}
}

function refreshSkillStarsOut(id, initialLevel) {
	
	for(var i=1; i<6; i++) {
		image = document.getElementById(id + i);
		if (image) { 
			var path = image.src;
			if(i<=initialLevel){
				if (path && path.length > 5){
					path = path.substring(0,path.length - 5)+"1"+path.substring(path.length - 4,path.length);
					image.src = path;
				}
			} else {
				if (path && path.length > 5){
					path = path.substring(0,path.length - 5)+"0"+path.substring(path.length - 4,path.length);
					image.src = path;
				}
			}
		}
	}
}

function sortSearchTable(contextPath, colIndex) {
	location.href=contextPath+"/main/search/sortTable.do?colIndex="+colIndex;
}


//RMCA
//function addMission(context, param) {
//	location.href=context + '/main/mission/addMission.do?matricule=' + param;
//}
//function editMission(context, matricule, idMission) {
//	location.href=context + '/main/mission/editMission.do?matricule=' + matricule + '&id='+idMission;
//}