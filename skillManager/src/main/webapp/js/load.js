$(function() {
	
	$("#accordion").accordion({
		heightStyle: "content",
		collapsible: true
	});
	
	
	$('#itemsDualListBox').bootstrapDualListbox({
		nonSelectedListLabel: 'Skills',
		selectedListLabel: 'Skills de la catégorie',
		moveSelectedLabel: '>',
		moveAllLabel: '>>',
		removeSelectedLabel: '<',
		removeAllLabel: '<<',
		infoTextEmpty: 'aucun skill sélectionné',
		selectorMinimalHeight: 100
	});
	
});