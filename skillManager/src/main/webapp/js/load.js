$(function() {
	
	$("#accordion").accordion({
		heightStyle: "content",
		collapsible: true
	});
	
	
	$('#itemsDualListBox').bootstrapDualListbox({
		nonSelectedListLabel: 'Skills',
		selectedListLabel: 'Skills de la cat�gorie',
		moveSelectedLabel: '>',
		moveAllLabel: '>>',
		removeSelectedLabel: '<',
		removeAllLabel: '<<',
		infoTextEmpty: 'aucun skill s�lectionn�',
		selectorMinimalHeight: 100
	});
	
});