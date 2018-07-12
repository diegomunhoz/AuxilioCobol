
           EXEC SQL DECLARE DB2PRD.TAREA_CONSD_UND TABLE
           (
              CPSSOA_JURID                   DECIMAL (10, 0)
                                             NOT NULL,
              NSEQ_UND_ORGNZ                 DECIMAL (8, 0)
                                             NOT NULL,
              CTPO_AREA_CONSD                DECIMAL (2, 0)
                                             NOT NULL,
              CUND_MEDD                      DECIMAL (3, 0)
                                             NOT NULL,
              MAREA_CONSD                    DECIMAL (9, 4)
           )
           END-EXEC.


       01  UORGB039.
           03 CPSSOA-JURID                   PIC S9(10)V COMP-3.
           03 NSEQ-UND-ORGNZ                 PIC S9(8)V COMP-3.
           03 CTPO-AREA-CONSD                PIC S9(2)V COMP-3.
           03 CUND-MEDD                      PIC S9(3)V COMP-3.
           03 MAREA-CONSD                    PIC S9(5)V9(4) COMP-3.
