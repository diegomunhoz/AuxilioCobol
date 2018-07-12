      ******************************************************************
      * DCLGEN TABLE(DB2PRD.TMANUT_EMPR_GRP)                           *
      *        LIBRARY(AD.DB2.DCLGEN(UORGB00J))                        *
      *        ACTION(REPLACE)                                         *
      *        LANGUAGE(COBOL)                                         *
      *        STRUCTURE(UORGB00J)                                     *
      *        APOST                                                   *
      *        LABEL(YES)                                              *
      *        DBCSDELIM(NO)                                           *
      * ... IS THE DCLGEN COMMAND THAT MADE THE FOLLOWING STATEMENTS   *
      ******************************************************************
           EXEC SQL DECLARE DB2PRD.TMANUT_EMPR_GRP TABLE                
           ( NSEQ_SOLTC_MANUT               DECIMAL(10, 0) NOT NULL,    
             CPSSOA_JURID_CONGL             DECIMAL(10, 0),             
             CSIT_DOCTO_FSCAL               DECIMAL(2, 0),              
             CTPO_PLANO_CTA                 DECIMAL(2, 0),              
             CTPO_PRTCP_EMPR                DECIMAL(2, 0),              
             DATA_INSTA_EMPR                DATE,                       
             HINSTA_EMPR                    TIME,                       
             NATA_INSTA_EMPR                DECIMAL(10, 0),             
             DENCRR_CTBIL                   DATE,                       
             DULT_ALT_ATA_INSTA             DATE,                       
             DENCRR_LEGAL                   DATE,                       
             NARQ_ATA_INSTA_UND             DECIMAL(12, 0),             
             NINSCR_REG_EMPR                DECIMAL(11, 0),             
             DARQ_ATA_INSTA_UND             DATE,                       
             NARQ_ATA_SEDE                  DECIMAL(12, 0),             
             DARQ_INSTA_SEDE                DATE                        
           ) END-EXEC.                                                  
      ******************************************************************
      * COBOL DECLARATION FOR TABLE DB2PRD.TMANUT_EMPR_GRP             *
      ******************************************************************
       01  UORGB00J.                                                    
      *    *************************************************************
           10 NSEQ-SOLTC-MANUT     PIC S9(10)V USAGE COMP-3.            
      *    *************************************************************
           10 CPSSOA-JURID-CONGL   PIC S9(10)V USAGE COMP-3.            
      *    *************************************************************
           10 CSIT-DOCTO-FSCAL     PIC S9(2)V USAGE COMP-3.             
      *    *************************************************************
           10 CTPO-PLANO-CTA       PIC S9(2)V USAGE COMP-3.             
      *    *************************************************************
           10 CTPO-PRTCP-EMPR      PIC S9(2)V USAGE COMP-3.             
      *    *************************************************************
           10 DATA-INSTA-EMPR      PIC X(10).                           
      *    *************************************************************
           10 HINSTA-EMPR          PIC X(8).                            
      *    *************************************************************
           10 NATA-INSTA-EMPR      PIC S9(10)V USAGE COMP-3.            
      *    *************************************************************
           10 DENCRR-CTBIL         PIC X(10).                           
      *    *************************************************************
           10 DULT-ALT-ATA-INSTA   PIC X(10).                           
      *    *************************************************************
           10 DENCRR-LEGAL         PIC X(10).                           
      *    *************************************************************
           10 NARQ-ATA-INSTA-UND   PIC S9(12)V USAGE COMP-3.            
      *    *************************************************************
           10 NINSCR-REG-EMPR      PIC S9(11)V USAGE COMP-3.            
      *    *************************************************************
           10 DARQ-ATA-INSTA-UND   PIC X(10).                           
      *    *************************************************************
           10 NARQ-ATA-SEDE        PIC S9(12)V USAGE COMP-3.            
      *    *************************************************************
           10 DARQ-INSTA-SEDE      PIC X(10).                           
      ******************************************************************
      * THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 16      *
      ******************************************************************
