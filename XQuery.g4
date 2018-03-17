grammar XQuery;


xq
    : '$' var       # XQVariable
    | StringConst   # XQStringConst
    | ap            # XQAp
    | '(' xq ')'    # XQPar
    | xq '/' rp     # XQChild
    | xq '//' rp    # XQAll
    | xq ',' xq     # XQDot
    | '<' NAME '>' '{' xq '}' '<' '/' NAME '>'      # XQTag
    | forClause letClause? whereClause? returnClause        #FLWR
    | letClause xq      #XQLet
    | joinClause    #XQJoin
    ;

var
    : NAME
    ;

attr
    : NAME
    ;
    
attrs
    :'[' attr (',' attr )* ']' #AllAttrs
    | '[]'						#NoAttrs
    ;
    

joinClause
    : 'join' '(' 
    xq ',' xq  
    ','
    attrs ',' attrs
    ')'
    ;

forClause
    : 'for' '$' var 'in' xq (',' '$' var 'in' xq)*
    ;
    

letClause
    : 'let' '$' var ':=' xq (',' '$' var ':=' xq)*
    ;

whereClause
    : 'where' cond
    ;

returnClause
    : 'return' xq
    ;

cond
    : xq '=' xq         #XQCondEqual
    | xq 'eq' xq        #XQCondEqual
    | xq '==' xq        #XQCondIs
    | xq 'is' xq        #XQCondIs
    | 'empty' '(' xq ')'    #XQCondEmpty
    | 'some' '$' var 'in' xq (',' '$' var 'in' xq)* 'satisfies' cond    #XQCondSome
    | '(' cond ')'      #XQCondPar
    | cond 'and' cond   #XQCondAnd
    | cond 'or' cond    #XQCondOr
    | 'not' cond        #XQCondNot
    ;

StringConst
    : '"'+[a-zA-Z0-9,.!?; ''""-]+'"'
    ;
    
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
:  doc '/' rp       # APChildren
|  doc '//' rp      # APAll
;

rp
: NAME                         # TagName
| '*'                          # AllChildren
| '.'                          # Current
| '..'                         # Parent
| TXT                              # Text
| '@' NAME                     # Attribute
| rp '/' rp                    # RpChildren
| rp '//' rp                   # RpAll
| rp ',' rp                    # TwoRp
| rp '[' fltr ']'              # RpFltr
| '(' rp ')'                   # RpwithP
;


doc 
: 'document("' fname '"' ')' 
| 'doc("' fname '"' ')' 
;

fname
: NAME ('.' NAME)?
;

TXT:    'text()';
NAME: [a-zA-Z0-9_-]+;
WS : [ \t\r\n]+ -> skip;