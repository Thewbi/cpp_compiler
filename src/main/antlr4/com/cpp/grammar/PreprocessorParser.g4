parser grammar PreprocessorParser;

options {
	tokenVocab = PreprocessorLexer;
}

code_file : ( preproc | code_block | NEWLINE )+ EOF;

code_block : TEXT+ (NEWLINE|EOF);
//code_block : NEWLINE;

// https://stackoverflow.com/questions/31255856/simple-antlr-preprocessor

// code_file : ( preproc | code_block )+ EOF ;

preproc : pifdef | pelse | pendif | pinclude ;
pifdef   : PIFDEFStart PIFDEFPTEXT+ PIFDEFPEOL   ; // the rules are unambiguous
pelse    : PELSEStart  PELSEPEOL          ; // even without matching the PEOLs
pendif   : PENDIFStart PENDIFPEOL          ;
pinclude : PINCLUDEStart PINCLUDEPTEXT+ PINCLUDEPEOL;

// code_block : TEXT NEWLINE;

