$(function() {
	$.datepicker.regional['fr'] = {
			closeText: 'Fermer',
			prevText: '&#x3c;Préc',
			nextText: 'Suiv&#x3e;',
			currentText: 'Courant',
			monthNames: ['Janvier','Février','Mars','Avril','Mai','Juin',
			'Juillet','Août','Septembre','Octobre','Novembre','Décembre'],
			monthNamesShort: ['Jan','Fév','Mar','Avr','Mai','Jun',
			'Jul','Aoû','Sep','Oct','Nov','Déc'],
			dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
			dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
			dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa'],
			weekHeader: 'Sm',
			dateFormat: 'dd/mm/yy',
			firstDay: 1,
			isRTL: false,
			showMonthAfterYear: false,
			yearSuffix: ''};
	
	$.browserLanguage = function(callback){
	     var language;
	     $.ajax({
	         url: "http://ajaxhttpheaders.appspot.com",
	         dataType: 'jsonp',
	         success: function(headers) {
	             language = headers['Accept-Language'].substring(0,2);
	             callback(language);
	         }
	     });
	   };
	
	
	$.browserLanguage(function(language){
		$.datepicker.setDefaults($.extend({dateFormat: "dd/mm/yy"}, $.datepicker.regional[language]));
	});
	
	
});