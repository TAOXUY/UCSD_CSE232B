grammar XQuery;






fltr
: rp                           # FltrRp
| rp '=' rp                    # FltrEqual
| rp 'eq' rp                   # FltrEqual
| rp '==' rp                   # FltrIs
| rp 'is' rp                   # FltrIs
| '(' fltr ')'                 # FltrwithP
| fltr 'and' fltr              # FltrAnd
| fltr 'or' fltr               # FltrOr
| 'not' fltr                   # FltrNot
;


ap
:  doc '/' rp 		# APChildren
|  doc '//' rp		# APAll
;

rp
: NAME                         # TagName
| '*'                          # AllChildren
| '.'                          # Current
| '..'                         # Parent
| TXT               	           # Text
| '@' NAME                     # Attribute
| rp '/' rp                    # RpChildren
| rp '//' rp                   # RpAll
| rp ',' rp                    # TwoRp
| rp '[' fltr ']'              # RpFltr
| '(' rp ')'                   # RpwithP
;


doc 
: 'doc("' fname '"' ')' 
;

fname
: NAME ('.' NAME)?
;

TXT:	'text()';
NAME: [a-zA-Z0-9_-]+;
WS : [ \t\r\n]+ -> skip;