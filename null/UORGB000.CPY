
           EXEC SQL DECLARE DB2PRD.TTPO_UND_ORGNZ TABLE
           (
              CTPO_UND_ORGNZ                 DECIMAL (3, 0)
                                             NOT NULL,
              ITPO_UND_ORGNZ                 CHAR (20)
                                             NOT NULL,
              CINDCD_DEPDT_UND               CHAR (1)
                                             NOT NULL,
              HINCL_REG                      TIMESTAMP
                                             NOT NULL,
              CUSUAR_INCL                    CHAR (9)
                                             NOT NULL,
              HMANUT_REG                     TIMESTAMP,
              CUSUAR_MANUT                   CHAR (9)
           )
           END-EXEC.


       01  UORGB000.
           03 CTPO-UND-ORGNZ                 PIC S9(3)V COMP-3.
           03 ITPO-UND-ORGNZ                 PIC X(20).
           03 CINDCD-DEPDT-UND               PIC X.
           03 HINCL-REG                      PIC X(26).
           03 CUSUAR-INCL                    PIC X(9).
           03 HMANUT-REG                     PIC X(26).
           03 CUSUAR-MANUT                   PIC X(9).
