/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

/**
 *
 * @author Yahya
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class MainScreen extends javax.swing.JFrame {

    DefaultTableModel cbt = new DefaultTableModel();
    DefaultTableModel abt = new DefaultTableModel();
    DefaultListModel glm1 = new DefaultListModel();
    DefaultListModel glm2 = new DefaultListModel();

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        cbt.setColumnIdentifiers(new String[]{"ID", "Name", "Genre", "Owner", "Given Date", "Return Date", "Status"});
        abt.setColumnIdentifiers(new String[]{"ID", "Name", "Genre", "Donater", "Archive Date"});
        edayTable.setModel(cbt);
        archiveTable.setModel(abt);
        genreListEday.setModel(glm1);
        genreListArchive.setModel(glm2);
        glm1.addElement("History");
        glm1.addElement("Fantasy");
        glm1.addElement("Politics");
        glm1.addElement("Philosophy");
        glm1.addElement("Children");
        glm1.addElement("Novel");
        glm2.addElement("History");
        glm2.addElement("Fantasy");
        glm2.addElement("Politics");
        glm2.addElement("Philosophy");
        glm2.addElement("Children");
        glm2.addElement("Novel");
        listc();
        lista();
        seeButtonEday.setVisible(false);
        seeButtonArchive.setVisible(false);
    }
    ArrayList<CommonBook> cbs = new ArrayList();
    ArrayList<ArchivedBook> abs = new ArrayList();

    public void listc() {
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stl = con.createStatement();
            ResultSet rs1 = stl.executeQuery("SELECT*FROM EDAYBOOK");
            cbs.add(new CommonBook());
            cbt.setRowCount(0);
            while (rs1.next()) {
                CommonBook cl = new CommonBook();
                cl.ID = rs1.getInt("ID");
                cl.name = rs1.getString("NAME");
                cl.genre = rs1.getString("GENRE");
                cl.Owner = rs1.getString("OWNER");
                cl.GivenDate = rs1.getDate("GIVEN_DATE");
                cl.ReturnDate = rs1.getDate("RETURN_DATE");
                cl.Status = rs1.getString("STATUS");
                cl.isExceeded();
                cbt.addRow(new String[]{(cl.ID + ""), cl.name, cl.genre, cl.Owner, (cl.GivenDate + ""), (cl.ReturnDate + ""), cl.Status});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        }
    }

    public void lista() {
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT*FROM ARCHIVEBOOK");
            abs.add(new ArchivedBook());
            abt.setRowCount(0);
            while (rs2.next()) {
                ArchivedBook a = new ArchivedBook();
                a.ID = rs2.getInt("ID");
                a.name = rs2.getString("NAME");
                a.genre = rs2.getString("GENRE");
                a.Donater = rs2.getString("DONATER");
                a.ArchiveDate = rs2.getDate("ARCHIVE_DATE");
                abt.addRow(new String[]{(a.ID + ""), a.name, a.genre, a.Donater, (a.ArchiveDate + "")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        }
    }

    public void clearcin() {
        IDtxtEday.setText("");
        NametxtEday.setText("");
        OwnertxtEday.setText("");
        GiventxtEday.setText("");
        ReturntxtEday.setText("");
        genreListEday.clearSelection();
    }

    public void clearain() {
        IDtxtArchive.setText("");
        nametxtArchive.setText("");
        donatertxtArchive.setText("");
        archivetxtArchive.setText("");
        genreListArchive.clearSelection();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArchivePanel = new javax.swing.JPanel();
        ArchiveLabelArchive = new javax.swing.JLabel();
        donatertxtArchive = new javax.swing.JTextField();
        NameLabelArchive = new javax.swing.JLabel();
        DonaterLabelArchive = new javax.swing.JLabel();
        IDLabelArchive = new javax.swing.JLabel();
        IDtxtArchive = new javax.swing.JTextField();
        archivetxtArchive = new javax.swing.JTextField();
        nametxtArchive = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        genreListArchive = new javax.swing.JList();
        GenreLabelArchive = new javax.swing.JLabel();
        addButtonArchive = new javax.swing.JButton();
        updateButtonArchive = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        edayTable = new javax.swing.JTable();
        searchtxtArchive = new javax.swing.JTextField();
        delButtonEday = new javax.swing.JButton();
        seeButtonArchive = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        archiveTable = new javax.swing.JTable();
        EdayCbox = new javax.swing.JComboBox();
        listLabelEday = new javax.swing.JLabel();
        Edaypanel = new javax.swing.JPanel();
        OwnerLabelEday = new javax.swing.JLabel();
        GiventxtEday = new javax.swing.JTextField();
        ReturnLabelEday = new javax.swing.JLabel();
        GivenLabelEday = new javax.swing.JLabel();
        IDLabelEday = new javax.swing.JLabel();
        NametxtEday = new javax.swing.JTextField();
        IDtxtEday = new javax.swing.JTextField();
        OwnertxtEday = new javax.swing.JTextField();
        ReturntxtEday = new javax.swing.JTextField();
        NameLabelEday = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        genreListEday = new javax.swing.JList();
        GenreLabelEday = new javax.swing.JLabel();
        addButtonEday = new javax.swing.JButton();
        updateButtonEday = new javax.swing.JButton();
        delButtonArchive = new javax.swing.JButton();
        listLabelArchive = new javax.swing.JLabel();
        ArchiveCbox = new javax.swing.JComboBox();
        copyButtonArchive = new javax.swing.JButton();
        copyButtonEday = new javax.swing.JButton();
        searchButtonArchive = new javax.swing.JButton();
        searchButtonEday = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        searchtxtEday = new javax.swing.JTextField();
        seeButtonEday = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        HelpMenu = new javax.swing.JMenu();
        AboutMenu = new javax.swing.JMenuItem();
        HelpcMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Management System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ArchivePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("For Archive Purpose Only"));

        ArchiveLabelArchive.setText("Archive Date");

        NameLabelArchive.setText("Name");

        DonaterLabelArchive.setText("Donater");

        IDLabelArchive.setText("Id");

        genreListArchive.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "History", "Fantasy", "Politics", "Philosophy", "Children's", "Novel" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(genreListArchive);

        GenreLabelArchive.setText("Genre");

        addButtonArchive.setText("Add");
        addButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonArchiveMouseClicked(evt);
            }
        });

        updateButtonArchive.setText("Update");
        updateButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonArchiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ArchivePanelLayout = new javax.swing.GroupLayout(ArchivePanel);
        ArchivePanel.setLayout(ArchivePanelLayout);
        ArchivePanelLayout.setHorizontalGroup(
            ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArchivePanelLayout.createSequentialGroup()
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDLabelArchive)
                            .addComponent(NameLabelArchive)
                            .addComponent(DonaterLabelArchive)
                            .addComponent(ArchiveLabelArchive))
                        .addGap(22, 22, 22)
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nametxtArchive, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(donatertxtArchive)
                            .addComponent(archivetxtArchive)
                            .addComponent(IDtxtArchive))
                        .addGap(18, 18, 18)
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GenreLabelArchive))
                        .addGap(15, 15, 15))
                    .addGroup(ArchivePanelLayout.createSequentialGroup()
                        .addComponent(addButtonArchive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButtonArchive)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ArchivePanelLayout.setVerticalGroup(
            ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchivePanelLayout.createSequentialGroup()
                .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArchivePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDLabelArchive)
                            .addComponent(IDtxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameLabelArchive)
                            .addComponent(nametxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DonaterLabelArchive)
                            .addComponent(donatertxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ArchiveLabelArchive)
                            .addComponent(archivetxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ArchivePanelLayout.createSequentialGroup()
                        .addComponent(GenreLabelArchive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ArchivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButtonArchive)
                    .addComponent(updateButtonArchive))
                .addContainerGap())
        );

        edayTable.setAutoCreateRowSorter(true);
        edayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        edayTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        edayTable.setShowVerticalLines(false);
        edayTable.setUpdateSelectionOnSort(false);
        edayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edayTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(edayTable);

        delButtonEday.setText("Delete Selected");
        delButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delButtonEdayMouseClicked(evt);
            }
        });

        seeButtonArchive.setText("See All");
        seeButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeButtonArchiveMouseClicked(evt);
            }
        });

        archiveTable.setAutoCreateRowSorter(true);
        archiveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        archiveTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        archiveTable.setShowVerticalLines(false);
        archiveTable.setUpdateSelectionOnSort(false);
        archiveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archiveTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(archiveTable);

        EdayCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Genre", "Owner" }));

        listLabelEday.setText("Search By:");

        Edaypanel.setBorder(javax.swing.BorderFactory.createTitledBorder("For Everyday Books"));

        OwnerLabelEday.setText("Owner");

        ReturnLabelEday.setText("Return Date");

        GivenLabelEday.setText("Given Date");

        IDLabelEday.setText("ID");

        NameLabelEday.setText("Name");

        genreListEday.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "History", "Fantasy", "Politics", "Philosophy", "Children's", "Novel" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(genreListEday);

        GenreLabelEday.setText("Genre");

        addButtonEday.setText("Add");
        addButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonEdayMouseClicked(evt);
            }
        });
        addButtonEday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonEdayActionPerformed(evt);
            }
        });

        updateButtonEday.setText("Update");
        updateButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonEdayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EdaypanelLayout = new javax.swing.GroupLayout(Edaypanel);
        Edaypanel.setLayout(EdaypanelLayout);
        EdaypanelLayout.setHorizontalGroup(
            EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdaypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EdaypanelLayout.createSequentialGroup()
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EdaypanelLayout.createSequentialGroup()
                                .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDLabelEday)
                                    .addComponent(NameLabelEday)
                                    .addComponent(OwnerLabelEday)
                                    .addComponent(GivenLabelEday))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EdaypanelLayout.createSequentialGroup()
                                .addComponent(ReturnLabelEday)
                                .addGap(18, 18, 18)))
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OwnertxtEday, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(NametxtEday)
                            .addComponent(GiventxtEday)
                            .addComponent(ReturntxtEday)
                            .addComponent(IDtxtEday))
                        .addGap(18, 18, 18)
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GenreLabelEday))
                        .addGap(15, 15, 15))
                    .addGroup(EdaypanelLayout.createSequentialGroup()
                        .addComponent(addButtonEday)
                        .addGap(18, 18, 18)
                        .addComponent(updateButtonEday)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        EdaypanelLayout.setVerticalGroup(
            EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EdaypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDLabelEday)
                        .addComponent(IDtxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GenreLabelEday, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EdaypanelLayout.createSequentialGroup()
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameLabelEday)
                            .addComponent(NametxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OwnerLabelEday)
                            .addComponent(OwnertxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GivenLabelEday)
                            .addComponent(GiventxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReturntxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReturnLabelEday)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EdaypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButtonEday)
                    .addComponent(updateButtonEday))
                .addContainerGap())
        );

        delButtonArchive.setText("Delete Selected");
        delButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delButtonArchiveMouseClicked(evt);
            }
        });

        listLabelArchive.setText("Search By:");

        ArchiveCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Genre", "Donater" }));

        copyButtonArchive.setText("Copy Info Into File");
        copyButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyButtonArchiveMouseClicked(evt);
            }
        });

        copyButtonEday.setText("Copy Info Into File");
        copyButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyButtonEdayMouseClicked(evt);
            }
        });
        copyButtonEday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonEdayActionPerformed(evt);
            }
        });

        searchButtonArchive.setText("Search");
        searchButtonArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonArchiveMouseClicked(evt);
            }
        });

        searchButtonEday.setText("Search");
        searchButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonEdayMouseClicked(evt);
            }
        });
        searchButtonEday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonEdayActionPerformed(evt);
            }
        });

        seeButtonEday.setText("See All");
        seeButtonEday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeButtonEdayMouseClicked(evt);
            }
        });

        HelpMenu.setText("Help");

        AboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        AboutMenu.setText("About");
        AboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutMenuMouseClicked(evt);
            }
        });
        AboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenu);

        HelpcMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        HelpcMenu.setText("Help Contents");
        HelpcMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpcMenuMouseClicked(evt);
            }
        });
        HelpcMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpcMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(HelpcMenu);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ArchivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(copyButtonArchive))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(listLabelArchive)
                        .addGap(18, 18, 18)
                        .addComponent(ArchiveCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchtxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButtonArchive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seeButtonArchive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButtonArchive)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Edaypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(copyButtonEday))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listLabelEday)
                        .addGap(18, 18, 18)
                        .addComponent(EdayCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchtxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButtonEday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seeButtonEday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButtonEday)))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchButtonEday)
                            .addComponent(listLabelEday)
                            .addComponent(EdayCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchtxtEday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delButtonEday)
                            .addComponent(seeButtonEday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyButtonEday)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Edaypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ArchivePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listLabelArchive)
                            .addComponent(ArchiveCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButtonArchive)
                            .addComponent(searchtxtArchive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delButtonArchive)
                            .addComponent(seeButtonArchive))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(copyButtonArchive)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edayTableMouseClicked
        if (edayTable.getRowSelectionAllowed() == true) {

            IDtxtEday.setText(edayTable.getValueAt(edayTable.getSelectedRow(), 0).toString());
            NametxtEday.setText(edayTable.getValueAt(edayTable.getSelectedRow(), 1).toString());
            genreListEday.setSelectedValue(edayTable.getValueAt(edayTable.getSelectedRow(), 2), false);
            OwnertxtEday.setText(edayTable.getValueAt(edayTable.getSelectedRow(), 3).toString());
            GiventxtEday.setText(edayTable.getValueAt(edayTable.getSelectedRow(), 4).toString());
            ReturntxtEday.setText(edayTable.getValueAt(edayTable.getSelectedRow(), 5).toString());
        
        }
    }//GEN-LAST:event_edayTableMouseClicked

    private void delButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delButtonEdayMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            stm.executeUpdate("DELETE FROM EDAYBOOK WHERE ID=" + edayTable.getValueAt(edayTable.getSelectedRow(), 0));

            clearcin();
            listc();

        } catch (java.lang.IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Please select a row from the Table", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        }

    }//GEN-LAST:event_delButtonEdayMouseClicked

    private void addButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonEdayMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            CommonBook c = new CommonBook();
            c.ID = Integer.parseInt(IDtxtEday.getText());
            c.name = NametxtEday.getText();
            c.genre = genreListEday.getSelectedValue().toString();
            c.Owner = OwnertxtEday.getText();
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            c.GivenDate = formatter.parse(GiventxtEday.getText());
            c.ReturnDate = formatter.parse(ReturntxtEday.getText());
            java.sql.Date sqlDateGiven = new java.sql.Date(c.GivenDate.getTime());
            java.sql.Date sqlDateReturn = new java.sql.Date(c.ReturnDate.getTime());
            c.isExceeded();
            stm.executeUpdate("INSERT INTO EDAYBOOK (ID,NAME,GENRE,OWNER,GIVEN_DATE,RETURN_DATE,STATUS) VALUES ("
                    + c.ID + ",'" + c.name + "','" + c.genre + "','" + c.Owner + "','" + sqlDateGiven + "', '" + sqlDateReturn + "', '" + c.Status + "')");
            cbt.setRowCount(0);
            for (CommonBook cb : cbs) {
                cbt.addRow(new String[]{c.ID + "", c.name, c.genre, c.Owner, sqlDateGiven + "", sqlDateReturn + ""});
            }
            clearcin();

            listc();
            edayTable.setRowSelectionAllowed(true);
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
        } catch (java.lang.NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
        } catch (org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a different ID.", "Error", WARNING_MESSAGE);
        } catch (java.sql.SQLDataException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
            System.out.println(ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
        }

    }//GEN-LAST:event_addButtonEdayMouseClicked

    private void updateButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonEdayMouseClicked
        if (edayTable.getRowSelectionAllowed() == true) {
            try {
                Connection con;
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
                Statement stm = con.createStatement();
                CommonBook c = new CommonBook();
                c.ID = Integer.parseInt(IDtxtEday.getText());
                c.name = NametxtEday.getText();
                c.genre = genreListEday.getSelectedValue().toString();
                c.Owner = OwnertxtEday.getText();
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                c.GivenDate = formatter.parse(GiventxtEday.getText());
                c.ReturnDate = formatter.parse(ReturntxtEday.getText());
                java.sql.Date sqlDateGiven = new java.sql.Date(c.GivenDate.getTime());
                java.sql.Date sqlDateReturn = new java.sql.Date(c.ReturnDate.getTime());
                c.isExceeded();
                stm.executeUpdate("UPDATE EDAYBOOK SET ID=" + c.ID + ", NAME='" + c.name + "', GENRE='" + c.genre + "', OWNER='" + c.Owner
                        + "', GIVEN_DATE='" + sqlDateGiven + "', RETURN_DATE='" + sqlDateReturn + "', STATUS='" + c.Status + "' "
                        + "WHERE ID=" + edayTable.getValueAt(edayTable.getSelectedRow(), 0).toString());
                clearcin();
                listc();

            } catch (java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
            } catch (java.lang.IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Please select a row from the Table.", "Error", WARNING_MESSAGE);
            } catch (org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a different ID.", "Error", WARNING_MESSAGE);
            } catch (java.sql.SQLDataException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateButtonEdayMouseClicked

    private void copyButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonEdayMouseClicked
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(this);
        PrintWriter wrt = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                wrt = new PrintWriter(file);
                wrt.println("");

                for (int row = 0; row < edayTable.getRowCount(); row++) {
                    for (int col = 0; col < edayTable.getColumnCount(); col++) {
                        wrt.print(edayTable.getColumnName(col));
                        wrt.print(": ");
                        wrt.println(edayTable.getValueAt(row, col));
                    }
                    wrt.println("");
                }
                JOptionPane.showMessageDialog(this, "Succesfully copied to the file.", "Done", INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No such file exsists.", "Error", ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
            } finally {
                wrt.close();
            }
        }
    }//GEN-LAST:event_copyButtonEdayMouseClicked

    private void searchButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonEdayMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            CommonBook cl = new CommonBook();
            cbt.setRowCount(0);

            if (EdayCbox.getSelectedItem().toString().equals("ID")) {
                cl.ID = Integer.parseInt(searchtxtEday.getText());
                ResultSet rs1 = stm.executeQuery("SELECT*FROM EDAYBOOK WHERE ID= " + cl.ID);
                while (rs1.next()) {
                    cl.ID = rs1.getInt("ID");
                    cl.name = rs1.getString("NAME");
                    cl.genre = rs1.getString("GENRE");
                    cl.Owner = rs1.getString("OWNER");
                    cl.GivenDate = rs1.getDate("GIVEN_DATE");
                    cl.ReturnDate = rs1.getDate("RETURN_DATE");
                    cl.Status = rs1.getString("STATUS");
                    cl.isExceeded();
                    cbt.addRow(new String[]{(cl.ID + ""), cl.name, cl.genre, cl.Owner, (cl.GivenDate + ""), (cl.ReturnDate + ""), cl.Status});
                }
            } else if (EdayCbox.getSelectedItem().toString().equals("Name")) {
                cl.name = searchtxtEday.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM EDAYBOOK WHERE NAME= '" + cl.name + "'");
                while (rs1.next()) {
                    cl.ID = rs1.getInt("ID");
                    cl.name = rs1.getString("NAME");
                    cl.genre = rs1.getString("GENRE");
                    cl.Owner = rs1.getString("OWNER");
                    cl.GivenDate = rs1.getDate("GIVEN_DATE");
                    cl.ReturnDate = rs1.getDate("RETURN_DATE");
                    cl.Status = rs1.getString("STATUS");
                    cl.isExceeded();
                    cbt.addRow(new String[]{(cl.ID + ""), cl.name, cl.genre, cl.Owner, (cl.GivenDate + ""), (cl.ReturnDate + ""), cl.Status});
                }
            } else if (EdayCbox.getSelectedItem().toString().equals("Genre")) {
                cl.genre = searchtxtEday.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM EDAYBOOK WHERE GENRE= '" + cl.genre + "'");
                while (rs1.next()) {
                    cl.ID = rs1.getInt("ID");
                    cl.name = rs1.getString("NAME");
                    cl.genre = rs1.getString("GENRE");
                    cl.Owner = rs1.getString("OWNER");
                    cl.GivenDate = rs1.getDate("GIVEN_DATE");
                    cl.ReturnDate = rs1.getDate("RETURN_DATE");
                    cl.Status = rs1.getString("STATUS");
                    cl.isExceeded();
                    cbt.addRow(new String[]{(cl.ID + ""), cl.name, cl.genre, cl.Owner, (cl.GivenDate + ""), (cl.ReturnDate + ""), cl.Status});
                }
            } else if (EdayCbox.getSelectedItem().toString().equals("Owner")) {
                cl.Owner = searchtxtEday.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM EDAYBOOK WHERE OWNER= '" + cl.Owner + "'");
                while (rs1.next()) {
                    cl.ID = rs1.getInt("ID");
                    cl.name = rs1.getString("NAME");
                    cl.genre = rs1.getString("GENRE");
                    cl.Owner = rs1.getString("OWNER");
                    cl.GivenDate = rs1.getDate("GIVEN_DATE");
                    cl.ReturnDate = rs1.getDate("RETURN_DATE");
                    cl.Status = rs1.getString("STATUS");
                    cl.isExceeded();
                    cbt.addRow(new String[]{(cl.ID + ""), cl.name, cl.genre, cl.Owner, (cl.GivenDate + ""), (cl.ReturnDate + ""), cl.Status});
                }
            }
            seeButtonEday.setVisible(true);
           
            addButtonEday.setEnabled(false);
            updateButtonEday.setEnabled(false);
            
            searchtxtEday.setText("");
            clearcin();
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables to the search field.", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        } finally {
            seeButtonEday.setVisible(true);
        }
    }//GEN-LAST:event_searchButtonEdayMouseClicked

    private void seeButtonEdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeButtonEdayMouseClicked
        edayTable.setRowSelectionAllowed(true);
        addButtonEday.setEnabled(true);
        updateButtonEday.setEnabled(true);
        delButtonEday.setEnabled(true);
        seeButtonEday.setVisible(false);
        searchtxtEday.setText("");

        listc();
    }//GEN-LAST:event_seeButtonEdayMouseClicked

    private void archiveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveTableMouseClicked
        if (archiveTable.getRowSelectionAllowed() == true) {

            IDtxtArchive.setText(archiveTable.getValueAt(archiveTable.getSelectedRow(), 0).toString());
            nametxtArchive.setText(archiveTable.getValueAt(archiveTable.getSelectedRow(), 1).toString());
            genreListArchive.setSelectedValue(archiveTable.getValueAt(archiveTable.getSelectedRow(), 2), false);
            donatertxtArchive.setText(archiveTable.getValueAt(archiveTable.getSelectedRow(), 3).toString());
            archivetxtArchive.setText(archiveTable.getValueAt(archiveTable.getSelectedRow(), 4).toString());

            lista();
        }
    }//GEN-LAST:event_archiveTableMouseClicked

    private void addButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonArchiveMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            ArchivedBook a = new ArchivedBook();
            a.ID = Integer.parseInt(IDtxtArchive.getText());
            a.name = nametxtArchive.getText();
            a.genre = genreListArchive.getSelectedValue().toString();
            a.Donater = donatertxtArchive.getText();
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            a.ArchiveDate = formatter.parse(archivetxtArchive.getText());
            java.sql.Date sqlDateArchived = new java.sql.Date(a.ArchiveDate.getTime());
            stm.executeUpdate("INSERT INTO ARCHIVEBOOK (ID,NAME,GENRE,DONATER,ARCHIVE_DATE) VALUES ("
                    + a.ID + ",'" + a.name + "','" + a.genre + "','" + a.Donater + "','" + sqlDateArchived + "')");
            abt.setRowCount(0);
            for (ArchivedBook ab : abs) {
                abt.addRow(new String[]{a.ID + "", a.name, a.genre, a.Donater, sqlDateArchived + ""});
            }
            clearain();
            lista();
            archiveTable.setRowSelectionAllowed(true);
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
        } catch (java.lang.NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
        } catch (org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a different ID.", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addButtonArchiveMouseClicked

    private void updateButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonArchiveMouseClicked
        if (archiveTable.getRowSelectionAllowed() == true) {
            try {
                Connection con;
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
                Statement stm = con.createStatement();
                ArchivedBook a = new ArchivedBook();
                a.ID = Integer.parseInt(IDtxtArchive.getText());
                a.name = nametxtArchive.getText();
                a.genre = genreListArchive.getSelectedValue().toString();
                a.Donater = donatertxtArchive.getText();
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                a.ArchiveDate = formatter.parse(archivetxtArchive.getText());
                java.sql.Date sqlDateArchived = new java.sql.Date(a.ArchiveDate.getTime());
                stm.executeUpdate("UPDATE ARCHIVEBOOK SET ID=" + a.ID + ", NAME='" + a.name + "', GENRE='" + a.genre + "', DONATER='" + a.Donater
                        + "', ARCHIVE_DATE='" + sqlDateArchived
                        + "' WHERE ID=" + archiveTable.getValueAt(archiveTable.getSelectedRow(), 0).toString());
                clearain();
                lista();

            } catch (java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
            } catch (java.lang.NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Please enter logical variables with no blank fields/selections left.", "Error", WARNING_MESSAGE);
            } catch (java.lang.IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Please select a row from the Table.", "Error", WARNING_MESSAGE);
            } catch (org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a different ID.", "Error", WARNING_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date with yyyy-mm-dd format.", "Error", WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_updateButtonArchiveMouseClicked

    private void delButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delButtonArchiveMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            stm.executeUpdate("DELETE FROM ARCHIVEBOOK WHERE ID=" + archiveTable.getValueAt(archiveTable.getSelectedRow(), 0));

            clearain();
            lista();

        } catch (java.lang.IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Please select a row from the Table", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_delButtonArchiveMouseClicked

    private void searchButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonArchiveMouseClicked
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads");
            Statement stm = con.createStatement();
            ArchivedBook al = new ArchivedBook();
            abt.setRowCount(0);

            if (ArchiveCbox.getSelectedItem().toString().equals("ID")) {
                al.ID = Integer.parseInt(searchtxtArchive.getText());
                ResultSet rs1 = stm.executeQuery("SELECT*FROM ARCHIVEBOOK WHERE ID= " + al.ID);
                while (rs1.next()) {
                    al.ID = rs1.getInt("ID");
                    al.name = rs1.getString("NAME");
                    al.genre = rs1.getString("GENRE");
                    al.Donater = rs1.getString("DONATER");
                    al.ArchiveDate = rs1.getDate("ARCHIVE_DATE");
                    abt.addRow(new String[]{(al.ID + ""), al.name, al.genre, al.Donater, (al.ArchiveDate + "")});
                }
            } else if (ArchiveCbox.getSelectedItem().toString().equals("Name")) {
                al.name = searchtxtArchive.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM ARCHIVEBOOK WHERE NAME= '" + al.name + "'");
                while (rs1.next()) {
                    al.ID = rs1.getInt("ID");
                    al.name = rs1.getString("NAME");
                    al.genre = rs1.getString("GENRE");
                    al.Donater = rs1.getString("DONATER");
                    al.ArchiveDate = rs1.getDate("ARCHIVE_DATE");
                    abt.addRow(new String[]{(al.ID + ""), al.name, al.genre, al.Donater, (al.ArchiveDate + "")});
                }
            } else if (ArchiveCbox.getSelectedItem().toString().equals("Genre")) {
                al.genre = searchtxtArchive.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM ARCHIVEBOOK WHERE GENRE= '" + al.genre + "'");
                while (rs1.next()) {
                    al.ID = rs1.getInt("ID");
                    al.name = rs1.getString("NAME");
                    al.genre = rs1.getString("GENRE");
                    al.Donater = rs1.getString("DONATER");
                    al.ArchiveDate = rs1.getDate("ARCHIVE_DATE");
                    abt.addRow(new String[]{(al.ID + ""), al.name, al.genre, al.Donater, (al.ArchiveDate + "")});
                }
            } else if (ArchiveCbox.getSelectedItem().toString().equals("Donater")) {
                al.Donater = searchtxtArchive.getText();
                ResultSet rs1 = stm.executeQuery("SELECT*FROM ARCHIVEBOOK WHERE DONATER= '" + al.Donater + "'");
                while (rs1.next()) {
                    al.ID = rs1.getInt("ID");
                    al.name = rs1.getString("NAME");
                    al.genre = rs1.getString("GENRE");
                    al.Donater = rs1.getString("DONATER");
                    al.ArchiveDate = rs1.getDate("ARCHIVE_DATE");
                    abt.addRow(new String[]{(al.ID + ""), al.name, al.genre, al.Donater, (al.ArchiveDate + "")});
                }
            }
            seeButtonArchive.setVisible(true);
            archiveTable.setRowSelectionAllowed(false);
            addButtonArchive.setEnabled(false);
            updateButtonArchive.setEnabled(false);
            delButtonArchive.setEnabled(false);
            searchtxtArchive.setText("");
            clearain();
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter logical variables to the search field.", "Error", WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
        } finally {
            seeButtonArchive.setVisible(true);
        }
    }//GEN-LAST:event_searchButtonArchiveMouseClicked

    private void seeButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeButtonArchiveMouseClicked
        archiveTable.setRowSelectionAllowed(true);
        addButtonArchive.setEnabled(true);
        updateButtonArchive.setEnabled(true);
        delButtonArchive.setEnabled(true);
        seeButtonArchive.setVisible(false);
        searchtxtArchive.setText("");
        lista();
    }//GEN-LAST:event_seeButtonArchiveMouseClicked

    private void copyButtonArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonArchiveMouseClicked
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(this);
        PrintWriter wrt = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                wrt = new PrintWriter(file);
                wrt.println("");

                for (int row = 0; row < archiveTable.getRowCount(); row++) {
                    for (int col = 0; col < archiveTable.getColumnCount(); col++) {
                        wrt.print(archiveTable.getColumnName(col));
                        wrt.print(": ");
                        wrt.println(archiveTable.getValueAt(row, col));
                    }
                    wrt.println("");
                }
                JOptionPane.showMessageDialog(this, "Succesfully copied to the file.", "Done", INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No such file exsists.", "Error", ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error ocurred.", "Error", WARNING_MESSAGE);
            } finally {
                wrt.close();
            }
        }


    }//GEN-LAST:event_copyButtonArchiveMouseClicked


    private void AboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutMenuMouseClicked
        new AboutMiniScreen().setVisible(true);
    }//GEN-LAST:event_AboutMenuMouseClicked

    private void HelpcMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpcMenuMouseClicked
        new HelpContentsMiniScreen().setVisible(true);
    }//GEN-LAST:event_HelpcMenuMouseClicked

    private void AboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuActionPerformed
        new AboutMiniScreen().setVisible(true);
    }//GEN-LAST:event_AboutMenuActionPerformed

    private void HelpcMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpcMenuActionPerformed
        new HelpContentsMiniScreen().setVisible(true);
    }//GEN-LAST:event_HelpcMenuActionPerformed

    private void backUpDatabase(Connection conn) throws SQLException {
        String sqlstmt = "CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)";
        String backupdirectory = "C:/Users/Yahya/Desktop/DB Backups";
        CallableStatement cs = conn.prepareCall(sqlstmt);
        cs.setString(1, backupdirectory);
        cs.execute();
        cs.close();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            backUpDatabase(DriverManager.getConnection("jdbc:derby://localhost:1527/asd", "asd", "ads"));
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void searchButtonEdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonEdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonEdayActionPerformed

    private void copyButtonEdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonEdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyButtonEdayActionPerformed

    private void addButtonEdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonEdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonEdayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenu;
    private javax.swing.JComboBox ArchiveCbox;
    private javax.swing.JLabel ArchiveLabelArchive;
    private javax.swing.JPanel ArchivePanel;
    private javax.swing.JLabel DonaterLabelArchive;
    private javax.swing.JComboBox EdayCbox;
    private javax.swing.JPanel Edaypanel;
    private javax.swing.JLabel GenreLabelArchive;
    private javax.swing.JLabel GenreLabelEday;
    private javax.swing.JLabel GivenLabelEday;
    private javax.swing.JTextField GiventxtEday;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem HelpcMenu;
    private javax.swing.JLabel IDLabelArchive;
    private javax.swing.JLabel IDLabelEday;
    private javax.swing.JTextField IDtxtArchive;
    private javax.swing.JTextField IDtxtEday;
    private javax.swing.JLabel NameLabelArchive;
    private javax.swing.JLabel NameLabelEday;
    private javax.swing.JTextField NametxtEday;
    private javax.swing.JLabel OwnerLabelEday;
    private javax.swing.JTextField OwnertxtEday;
    private javax.swing.JLabel ReturnLabelEday;
    private javax.swing.JTextField ReturntxtEday;
    private javax.swing.JButton addButtonArchive;
    private javax.swing.JButton addButtonEday;
    private javax.swing.JTable archiveTable;
    private javax.swing.JTextField archivetxtArchive;
    private javax.swing.JButton copyButtonArchive;
    private javax.swing.JButton copyButtonEday;
    private javax.swing.JButton delButtonArchive;
    private javax.swing.JButton delButtonEday;
    private javax.swing.JTextField donatertxtArchive;
    private javax.swing.JTable edayTable;
    private javax.swing.JList genreListArchive;
    private javax.swing.JList genreListEday;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel listLabelArchive;
    private javax.swing.JLabel listLabelEday;
    private javax.swing.JTextField nametxtArchive;
    private javax.swing.JButton searchButtonArchive;
    private javax.swing.JButton searchButtonEday;
    private javax.swing.JTextField searchtxtArchive;
    private javax.swing.JTextField searchtxtEday;
    private javax.swing.JButton seeButtonArchive;
    private javax.swing.JButton seeButtonEday;
    private javax.swing.JButton updateButtonArchive;
    private javax.swing.JButton updateButtonEday;
    // End of variables declaration//GEN-END:variables
}
