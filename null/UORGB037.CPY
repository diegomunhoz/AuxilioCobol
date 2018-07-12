
           EXEC SQL DECLARE DB2PRD.TACSSO_UND_ORGNZ TABLE
           (
              CTPO_ACSSO_ORGNZ               DECIMAL (2, 0)
                                             NOT NULL,
              CPSSOA_JURID                   DECIMAL (10, 0)
                                             NOT NULL,
              NSEQ_UND_ORGNZ                 DECIMAL (8, 0)
                                             NOT NULL
           )
           END-EXEC.


       01  UORGB037.
           03 CTPO-ACSSO-ORGNZ               PIC S9(2)V COMP-3.
           03 CPSSOA-JURID                   PIC S9(10)V COMP-3.
           03 NSEQ-UND-ORGNZ                 PIC S9(8)V COMP-3.
