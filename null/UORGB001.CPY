
           EXEC SQL DECLARE DB2PRD.TNATUZ_UND_ORGNZ TABLE
           (
              CNATUZ_UND_ORGNZ               DECIMAL (1, 0)
                                             NOT NULL,
              INATUZ_UND_ORGNZ               CHAR (40)
                                             NOT NULL,
              HINCL_REG                      TIMESTAMP
                                             NOT NULL,
              CUSUAR_INCL                    CHAR (9)
                                             NOT NULL,
              HMANUT_REG                     TIMESTAMP,
              CUSUAR_MANUT                   CHAR (9)
           )
           END-EXEC.


       01  UORGB001.
           03 CNATUZ-UND-ORGNZ               PIC S9(1)V COMP-3.
           03 INATUZ-UND-ORGNZ               PIC X(40).
           03 HINCL-REG                      PIC X(26).
           03 CUSUAR-INCL                    PIC X(9).
           03 HMANUT-REG                     PIC X(26).
           03 CUSUAR-MANUT                   PIC X(9).
