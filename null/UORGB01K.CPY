
           EXEC SQL DECLARE DB2PRD.TMANUT_PRDIO_OCPDO TABLE
           (
              NSEQ_SOLTC_MANUT               DECIMAL (10, 0)
                                             NOT NULL,
              CTPO_SIT_PRDIO                 DECIMAL (2, 0),
              RTPO_SIT_PRDIO                 CHAR (20),
              CSIT_ATUAL_REG                 DECIMAL (1, 0)
                                             NOT NULL
           )
           END-EXEC.


       01  UORGB01K.
           03 NSEQ-SOLTC-MANUT               PIC S9(10)V COMP-3.
           03 CTPO-SIT-PRDIO                 PIC S9(2)V COMP-3.
           03 RTPO-SIT-PRDIO                 PIC X(20).
           03 CSIT-ATUAL-REG                 PIC S9(1)V COMP-3.
