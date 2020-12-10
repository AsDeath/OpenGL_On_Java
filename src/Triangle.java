import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Triangle implements GLEventListener {

    private GLU glu = new GLU();
    private float rtri = 0.0f;
    private float rquad = 0.0f;

    // Начало рисования пирамиды
    public void DrawTriangle(final GL2 gl){
        gl.glLoadIdentity(); // Reset The View
        gl.glTranslatef( -1.5f,0.0f,-6.0f ); // Move the triangle
        gl.glRotatef( rtri, 1.0f, 1.0f, 0.0f );
        gl.glBegin( GL2.GL_TRIANGLES );

        //drawing triangle in all dimensions
        //front
        gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
        gl.glVertex3f( 0.0f, 1.0f, 0.0f ); // Top

        gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Left

        gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Right)

        //right
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glVertex3f( 0.0f, 1.0f, 0.0f ); // Top

        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Left

        gl.glColor3f( 0.0f, 1.0f, 0.0f );
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right

        //left
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glVertex3f( 0.0f, 1.0f, 0.0f ); // Top

        gl.glColor3f( 0.0f, 1.0f, 0.0f );
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Left

        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Right

        //top
        gl.glColor3f( 0.0f, 1.0f, 0.0f );
        gl.glVertex3f( 0.0f, 1.0f, 0.0f ); // Top

        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left

        gl.glColor3f( 0.0f, 1.0f, 0.0f );
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Right

        gl.glEnd(); // Done Drawing 3d triangle (Pyramid)

        gl.glFlush();
        rtri += 0.1f;
    }

    public void DrawQuad(GL2 gl){
        gl.glLoadIdentity();
        gl.glTranslatef( 1.5f,0.0f,-7.0f ); // Move the triangle
        gl.glRotatef( rquad, 1.0f, 1.0f, 1.0f ); // Вращение куба по X, Y & Z
        gl.glBegin( GL2.GL_QUADS);       // Рисуем куб

        gl.glColor3f(0.0f,1.0f,0.0f);              // Синий
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Право верх квадрата (Верх)
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Лево верх
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Лево низ
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Право низ

        gl.glColor3f(1.0f,0.5f,0.0f);              // Оранжевый
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Верх право квадрата (Низ)
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Верх лево
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Низ лево
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Низ право

        gl.glColor3f(1.0f,0.0f,0.0f);              // Красный
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Верх право квадрата (Перед)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Верх лево
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Низ лево
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Низ право

        gl.glColor3f(1.0f,1.0f,0.0f);              // Желтый
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Верх право квадрата (Зад)
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Верх лево
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Низ лево
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Низ право

        gl.glColor3f(0.0f,0.0f,1.0f);              // Синий
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Верх право квадрата (Лево)
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Верх лево
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Низ лево
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Низ право

        gl.glColor3f(1.0f,0.0f,1.0f);              // Фиолетовый
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Верх право квадрата (Право)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Верх лево
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Низ лево
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Низ право
        gl.glEnd();                                // Закончили квадраты

        rquad-=0.15f;
    }
    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();

        gl.glShadeModel( GL2.GL_SMOOTH );
        gl.glClearColor( 0f, 0f, 0f, 0f );
        gl.glClearDepth( 1.0f );
        gl.glEnable( GL2.GL_DEPTH_TEST );
        gl.glDepthFunc( GL2.GL_LEQUAL );
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

        // Clear The Screen And The Depth Buffer
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        DrawTriangle(gl);
        DrawQuad(gl);
    }

    @Override
    public void dispose( GLAutoDrawable drawable ) {
    }

    @Override
    public void init( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();

        gl.glShadeModel( GL2.GL_SMOOTH );
        gl.glClearColor( 0f, 0f, 0f, 0f );
        gl.glClearDepth( 1.0f );
        gl.glEnable( GL2.GL_DEPTH_TEST );
        gl.glDepthFunc( GL2.GL_LEQUAL );
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height ) {

        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        if( height <= 0 )
            height = 1;

        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }

    public static void main( String[] args ) {

        // TODO Auto-generated method stub
        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Triangle triangle = new Triangle();



        glcanvas.addGLEventListener(triangle);
        glcanvas.setSize( 900, 600 );

        final JFrame frame = new JFrame ( "3d Triangle (solid)" );
        frame.getContentPane().add(glcanvas);
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
        final FPSAnimator animator = new FPSAnimator( glcanvas, 300,true);

        animator.start();

    }

}