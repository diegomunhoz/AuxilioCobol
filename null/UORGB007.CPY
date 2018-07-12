
           EXEC SQL DECLARE DB2PRD.TUND_ORGNZ TABLE
           (
              CPSSOA_JURID                   DECIMAL (10, 0)
                                             NOT NULL,
              NSEQ_UND_ORGNZ                 DECIMAL (8, 0)
                                             NOT NULL,
              CPSSOA_UND_ORGNZ               DECIMAL (10, 0)
                                             NOT NULL,
              CSIT_UND_ORGNZ                 DECIMAL (3, 0),
              CCLASF_UND_ORGNZ               DECIMAL (1, 0),
              CTPO_UND_ORGNZ                 DECIMAL (3, 0),
              IUND_ORGNZ                     CHAR (60),
              IABREV_UND_ORGNZ               CHAR (40)
                                             NOT NULL,
              CUND_ORGNZ                     DECIMAL (6, 0)
                                             NOT NULL,
              CDIG_UND_ORGNZ                 CHAR (1),
              CLOGDR_CMBIO_ORGNZ             DECIMAL (5, 0),
              HINCL_REG                      TIMESTAMP
                                             NOT NULL,
              CUSUAR_INCL                    CHAR (9)
                                             NOT NULL,
              CUSUAR_MANUT                   CHAR (9)
           )
           END-EXEC.


       01  UORGB007.
           03 CPSSOA-JURID                   PIC S9(10)V COMP-3.
           03 NSEQ-UND-ORGNZ                 PIC S9(8)V COMP-3.
           03 CPSSOA-UND-ORGNZ               PIC S9(10)V COMP-3.
           03 CSIT-UND-ORGNZ                 PIC S9(3)V COMP-3.
           03 CCLASF-UND-ORGNZ               PIC S9(1)V COMP-3.
           03 CTPO-UND-ORGNZ                 PIC S9(3)V COMP-3.
           03 IUND-ORGNZ                     PIC X(60).
           03 IABREV-UND-ORGNZ               PIC X(40).
           03 CUND-ORGNZ                     PIC S9(6)V COMP-3.
           03 CDIG-UND-ORGNZ                 PIC X.
           03 CLOGDR-CMBIO-ORGNZ             PIC S9(5)V COMP-3.
           03 HINCL-REG                      PIC X(26).
           03 CUSUAR-INCL                    PIC X(9).
           03 CUSUAR-MANUT                   PIC X(9).
