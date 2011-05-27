/**
 * @author S³awomir Kok³owski {@link http://www.kurshtml.boo.pl}
 * @copyright NIE usuwaj tego komentarza! (Do NOT remove this comment!)
 */

// Domyœlny identyfikator IFRAME:
var autoiframe_id = 'autoiframe';
// Domyœlny dolny margines:
var autoiframe_margin = 30;

var autoiframe_timer = null;
function autoiframe(id, margin)
{
	if (parent != self && document.body && document.body.offsetHeight && document.body.scrollHeight)
	{
		clearTimeout(autoiframe_timer)
		if (typeof id != 'undefined' && id) autoiframe_id = id;
		parent.document.getElementById(autoiframe_id).height = 1;
		autoiframe_timer = setTimeout("parent.document.getElementById(autoiframe_id).height = Math.max(document.body.offsetHeight, document.body.scrollHeight) + " + (typeof margin == 'undefined' || isNaN(parseInt(margin)) ? autoiframe_margin : parseInt(margin)), 1);
	}
}

if (window.addEventListener) window.addEventListener('load', function() { autoiframe(); }, false);
else if (window.attachEvent) window.attachEvent('onload', function() { autoiframe(); });