/**
 * 
 */

var map;
var diagramMap;
var diagramFormat;
var iconMap;

var mainModal;
var mainModalContent;
var modalElements = [];
var introductionElements = [];
var overloadingElements = [];
var overridingElements = [];
var coercionElements = [];
var inclusionElements = [];
var genericsElements = [];

$(document).ready(function(){
	initialize();
	$(mainModal).on('shown.bs.modal', function(){setModalFocus();})
	$(stringify(modalElements)).click(function(){setModalDiagram(this);});
	$("#home").click(()=>{collapseAll();});
	$(stringify(introductionElements)).click(()=>{setView(attributes.introduction);});
	$(stringify(overloadingElements)).click(()=>{setView(attributes.overloading);});
	$(stringify(overridingElements)).click(()=>{setView(attributes.overriding);});
	$(stringify(coercionElements)).click(()=>{setView(attributes.coercion);});
	$(stringify(inclusionElements)).click(()=>{setView(attributes.inclusion);});
	$(stringify(genericsElements)).click(()=>{setView(attributes.generics);});
});

function initialize(){
	initMaps();
	initModals();
	initElements([
		{elements: introductionElements, attribute: attributes.introduction},
		{elements: overloadingElements, attribute: attributes.overloading},
		{elements: overridingElements, attribute: attributes.overriding},
		{elements: coercionElements, attribute: attributes.coercion},
		{elements: inclusionElements, attribute: attributes.inclusion},
		{elements: genericsElements, attribute: attributes.generics}
	]);
	
	console.log(stringify(coercionElements));
	console.log(stringify(genericsElements));
}




