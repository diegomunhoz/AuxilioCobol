
           EXEC SQL DECLARE DB2PRD.TCLASF_AG TABLE
           (
              CCLASF_AG                      DECIMAL (3, 0)
                                             NOT NULL,
              ICLASF_AG                      CHAR (20),
              HINCL_REG                      TIMESTAMP
                                             NOT NULL,
              CUSUAR_INCL                    CHAR (9)
                                             NOT NULL,
              HMANUT_REG                     TIMESTAMP,
              CUSUAR_MANUT                   CHAR (9),
              CSIT_ATUAL_REG                 DECIMAL (1, 0)
                                             NOT NULL
                                             WITH DEFAULT
           )
           END-EXEC.


       01  UORGB002.
           03 CCLASF-AG                      PIC S9(3)V COMP-3.
           03 ICLASF-AG                      PIC X(20).
           03 HINCL-REG                      PIC X(26).
           03 CUSUAR-INCL                    PIC X(9).
           03 HMANUT-REG                     PIC X(26).
           03 CUSUAR-MANUT                   PIC X(9).
           03 CSIT-ATUAL-REG                 PIC S9(1)V COMP-3.
